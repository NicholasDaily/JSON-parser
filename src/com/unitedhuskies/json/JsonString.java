package com.unitedhuskies.json;

public class JsonString extends Json {
	
	private String value;
	
	JsonString(){                                             
		super(JsonType.STRING);
		this.value = "";
	}
	
	JsonString(String value){
		super(JsonType.STRING);
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return "\"" + value + "\"";
	}
	
	

}
