package com.yliu.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BuildDataTest {
	private static Map<String,List<NetValue>> idNetValues = new HashMap<>();
	private static int total = 0;
	public static void main(String[] args) {
		int count = 0;
		while(count<8000){
			String id = UUID.randomUUID().toString();
			idNetValues.put(id, new ArrayList<>());
			count++;
		}
		
		int days = 1000;
		Date date = new Date();
		List<NetValue> vs = new ArrayList<>();
		int batchSize = 500;
		while(days>0){
			date = new Date(date.getTime()-86400000);
			double value = Math.random()+1;
			NetValue nv = new NetValue(date.getTime(), value);
			vs.add(nv);
			idNetValues.values().forEach(list->{
				list.add(nv);
				total++;
			});
			if(vs.size()>=batchSize){
				System.out.println(String.format("保存总数=%s", total));
				showCache();
			}
			days--;
		}
		while(true){
			
		}
	}
	
	public static void showCache(){
		long maxMem = Runtime.getRuntime().maxMemory()/1024/1024;
        long freeMem = Runtime.getRuntime().freeMemory()/1024/1024;
        long usedMem = maxMem - freeMem;
        
        System.out.println(String.format("使用内存=%s,剩余内存=%s", usedMem,freeMem));
	}
}
