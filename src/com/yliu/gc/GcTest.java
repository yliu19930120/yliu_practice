package com.yliu.gc;

/**
 * 运行参数 加入 -verbose:gc  -XX:+PrintGCTimeStamps -XX:+PrintGCDetails 打印出gc日志
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年3月23日 下午7:33:59
 */
public class GcTest {
	public Object instance = null;
	private final static int _1MB = 1024 * 1024;
	/**
	 * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
	 */
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void main(String[] args) {
		GcTest.testGC();
	}
	
	public static void testGC() {
		GcTest objA = new GcTest();
		GcTest objB = new GcTest();
		objA.instance = objB;
		objB.instance = objA;
		objA = null;
		objB = null;
		// 假设在这行发生GC,objA和objB是否能被回收？
		System.gc();
	}
}
