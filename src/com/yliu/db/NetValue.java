package com.yliu.db;

public class NetValue {
	
	private long time;
	private double value;
	private String id;
	
	public NetValue() {
		super();
	}
	public NetValue(long time, double value) {
		super();
		this.time = time;
		this.value = value;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
