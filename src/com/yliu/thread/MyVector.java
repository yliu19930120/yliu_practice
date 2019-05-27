package com.yliu.thread;

import java.util.Vector;

public class MyVector<T> {
		
	private Vector<T> vector;
	
	public MyVector() {
		this.vector = new Vector<>();
	}
	
	public synchronized boolean contains(T t){
		return this.vector.contains(t);
	}
	
	public synchronized void add(T t){
		this.vector.add(t);
	}
	
	public synchronized void syncadd(T t){
		if(!vector.contains(t)){
			vector.add(t);
		}
	}

	public Vector<T> getVector() {
		return vector;
	}


	public void setVector(Vector<T> vector) {
		this.vector = vector;
	}
	
	
}
