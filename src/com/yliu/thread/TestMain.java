package com.yliu.thread;

public class TestMain {
	
	public static void main(String[] args) {
		LoggingWedght w = new LoggingWedght();
		new Thread(()->w.doSomeThing()).start();
		new Thread(()->w.doSomeThing()).start();
	}
}
