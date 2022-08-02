package com.unitedhuskies.json;

public class JsonBoolean extends Json {
	private boolean value;
	
	JsonBoolean(){
		super(JsonType.BOOLEAN);
		this.value = false;
	}
	
	JsonBoolean(String key){
		super(key, JsonType.BOOLEAN);
		this.value = false;
	}
	
	JsonBoolean(boolean value){
		super(JsonType.BOOLEAN);
		this.value = value;
	}
	
	JsonBoolean(boolean value, String key){
		super(key, JsonType.BOOLEAN);
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
