package com.yliu.gc;

/**
 * finalize 方法的示例
 * 
 * @author YLiu
 * @Email yliu19930120@163.com
 * 2019年3月23日 下午7:25:06
 */
public class SaveUsTest {
	public static SaveUsTest SAVE_HOOK = null;

	public void isAlive() {
		System.out.println("yes,i am still alive:)");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize mehtod executed!");
		SaveUsTest.SAVE_HOOK = this;
	}
	
	/**
	 *  1.第一次调用 gc(),会执行finalize方法,而此类中的finalize 讲示例本身赋值给自己完成了自救。索引对象不会被回收
	 *  2.第二次调用gc(),finalize方法已经被调用了一次，此时对象被回收1
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new SaveUsTest();
		// 对象第一次成功拯救自己
		SAVE_HOOK = null;
		System.gc();
		// 因为finalize方法优先级很低，所以暂停0.5秒以等待它
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no,i am dead:(");
		}
		// 下面这段代码与上面的完全相同，但是这次自救却失败了
		SAVE_HOOK = null;
		System.gc();
		// 因为finalize方法优先级很低，所以暂停0.5秒以等待它
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no,i am dead:(");
		}
	}

}
