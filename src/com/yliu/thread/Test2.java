package com.yliu.thread;

/**
 * 共享变量的冲突
 * 重点是每个线程执行后，都会copy一份变量到自己的内存空间当中，加快读取速度
 * 但是结果就是可能A线程写入的变量,B线程获取不到
 * Read线程启动之后，主线程对静态变量赋值
 * 可能情况1.主线程赋值true之后此时Read线程停止，但此时num赋值还未到达，打印出0
 * 可能情况2.主线程赋值的true，Read线程永远无法读取到
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年5月26日 下午8:02:54
 */
public class Test2 {
	private static boolean ready;
	private static int number;
	
	private static class ReadThread extends Thread{

		@Override
		public void run() {
				while (!ready){
					System.out.println(ready);
					Thread.yield();
				}
				System.out.println(number);
		}
		
	}
	public static void main(String[] args) {
		new ReadThread().start();
		ready = true;
		number = 42;
	}
}
