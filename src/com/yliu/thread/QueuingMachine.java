package com.yliu.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 叫号机程序
 * 1.最多发5个号
 * 2.4个叫号机
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年4月9日 下午9:01:30
 */
public class QueuingMachine  {
	
		private final static int NUM_SIZE = 50;
		private static  AtomicInteger count_atomic = new AtomicInteger(0);
		
		public static void main(String[] args) {
			new QueuingMachine().go();
		}
		
		public void go(){
			Runnable r = getQueuningRunnable();
			for(int i=0;i<4;i++){
				new Thread(r).start();
			}
		}
		/**
		 * 叫号,叫完了号码+1
		 */
		private void queuning(){
			while(count_atomic.getAndIncrement()<=NUM_SIZE){
				System.out.println(String.format("请%s号客户办理业务", count_atomic.get()));
			}
				System.out.println("对不起没号了");
		}
		
		private Runnable getQueuningRunnable(){
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					queuning();
				}
			};
			return runnable;
		}
}
