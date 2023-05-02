package com.nicholasDaily.json;

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
	
	private final JsonType type;
	
	Json(JsonType type){
		this.type = type;
	}
	
	public JsonType getType() {
		return type;
	}
	
	
}
