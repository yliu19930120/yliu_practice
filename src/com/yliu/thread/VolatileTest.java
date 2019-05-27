package com.yliu.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile关键字的使用
 * 下面演示十个线程对volatile修饰的静态变量的自增100次操作
 * 理论上被volatile修饰的变量a，任何线程对a的修改都会刷新到共享内存当中
 * 那么a的值应该为1000
 * 实际上不是,volatile变量只保证了读或者写的原子性，但是自增是一个读取写入的复合操作
 * 假设当线程A读取的a的值为10，但此时A线程被阻塞。然后B线程获取了变量a同样为10,B对a自增1，a为11，
 * 而后A接着执行，但此时A还是拿的之前获取的值10，再自增a=11写入共享内存
 * 这样的结果会导致，最终运行的结果不一定为1000
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年5月26日 下午11:36:24
 */
public class VolatileTest {
	private volatile static int a;
	
	private static void test(){
		List<Thread> threads = new ArrayList<>();
		for(int i=0;i<10;i++){
			threads.add(new Thread(()->{
				for (int j = 0; j < 100; j++) {
					a++;
//					System.out.println(a);
				}
			}));
		}
		
		threads.forEach(Thread::start);
		threads.forEach(thread->{try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}});
		System.out.println(a);
		VolatileTest.a=0;
	}
	
	public static void main(String[] args) {
		test();
	}
}
