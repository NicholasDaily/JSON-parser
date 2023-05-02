package com.nicholasDaily.json;

public class JsonBoolean extends Json {
	private boolean value;
	
	JsonBoolean(){
		super(JsonType.BOOLEAN);
		this.value = false;
	}
	
	JsonBoolean(boolean value){
		super(JsonType.BOOLEAN);
		this.value = value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return "" + this.value;
	}
	
}
