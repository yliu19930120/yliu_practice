package com.yliu.thread;

import java.util.concurrent.TimeUnit;

public class LoggingWedght extends Wedght{

	@Override
	public synchronized void doSomeThing() {
		System.out.println(toString() + " ： calling doSomething"); 
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.doSomeThing();
	}

}
