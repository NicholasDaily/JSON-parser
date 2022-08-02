package com.unitedhuskies.json;

public class JsonNull extends Json {
	private String value = "null";
	JsonNull() {
		super(JsonType.NULL);
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
