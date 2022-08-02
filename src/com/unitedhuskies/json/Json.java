package com.unitedhuskies.json;

public abstract class Json{
	public static enum JsonType{
		STRING,
		DOUBLE,
		INT,
		OBJECT,
		LIST,
		BOOLEAN,
		NULL
	};
	
	private String key;
	private final JsonType type;
	
	Json(JsonType type){
		this.type = type;
	}
	
	Json(String key, JsonType type){
		this.key = key;
		this.type = type;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public JsonType getType() {
		return type;
	}
	
	
}
