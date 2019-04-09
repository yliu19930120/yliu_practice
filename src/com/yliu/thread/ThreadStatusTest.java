package com.yliu.thread;

/**
 * 类展示线程的5中状态
 * 1.new 新建线程对象和普通对象无区别
 * 2.runnable 调用线程的start方法,此时线程并未启动。真正启动需要CPU的调度
 * 3.running CPU轮询到该线程时，才会执行线程的内部逻辑
 * 4.blocked 线程进入阻塞状态,显式调用wait和sleep方法会进入阻塞状态
 * 5.terminate 线程周期进入结束的状态，次状态不能再进行到线程的其他状态
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年4月8日 下午9:16:38
 */
public class ThreadStatusTest {
		
	public static void main(String[] args) {
		Thread thread = new Thread(()->System.out.println("你好"));
		thread.start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
