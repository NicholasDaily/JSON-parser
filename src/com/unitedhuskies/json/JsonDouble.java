package com.unitedhuskies.json;

public class JsonDouble extends Json {
	private double value;
	
	JsonDouble(){
		super(JsonType.DOUBLE);
		this.value = 0;
	}
	
	JsonDouble(double value){
		super(JsonType.DOUBLE);
		this.value = value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
	
	
}
