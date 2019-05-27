package com.yliu.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.yliu.utils.JsonUtil;

/**
 * 要保证读写操作同步，分别同步两个方法没有用
 * 必须对多个代码块加锁
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年5月27日 下午9:10:35
 */
public class VectorTest {
	
		public static void main(String[] args) {
			for(int i=0;i<10;i++){
				test2();
			}
		}
		
		public static void test1(){
			Vector<Integer> vt = new Vector<>();
			for(int x=0;x<10;x++){
				new Thread(()->{
					for(int i=0;i<10;i++){
						if(!vt.contains(i)){
							vt.add(i);
						}
					}
				}).start();
			}
			System.out.println(JsonUtil.toJson(vt));
		}
		
		
		public static void test2(){
			MyVector<Integer> vt = new MyVector<>();
			List<Thread> threads = new ArrayList<>();
			for(int x=0;x<10;x++){
				threads.add(new Thread(()->{
					for(int i=0;i<10;i++){
							if(!vt.contains(i)){
								vt.add(i);
							}
//						vt.syncadd(i);
					}
				}));
			}
			threads.forEach(Thread::start);
			threads.forEach(thread->{
				try {
					thread.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			System.out.println(JsonUtil.toJson(vt.getVector()));
		}
}
