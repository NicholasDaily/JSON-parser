package com.unitedhuskies.json;

public class JsonInt extends Json {
	
	private int value;
	
	JsonInt(){
		super(JsonType.INT);
		this.value = 0;
	}
	
	JsonInt(String key){
		super(key, JsonType.INT);
		this.value = 0;
	}
	
	JsonInt(int value){
		super(JsonType.INT);
		this.value = value;
	}
	
	JsonInt(int value, String key){
		super(key, JsonType.INT);
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
	
	

}
