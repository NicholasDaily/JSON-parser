package com.nicholasDaily.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

public class JsonObject extends Json {
	
	private Hashtable<String, Json> value = new Hashtable<>();
	
	JsonObject(){
		super(JsonType.OBJECT);
	}
	
	JsonObject(Hashtable<String, Json> value){
		super(JsonType.OBJECT);
		this.value = (Hashtable<String, Json>) value.clone();
	}
	
	JsonObject(ArrayList<Json> value){
		super(JsonType.OBJECT);
		this.value = (Hashtable<String, Json>) value.clone();
	}
	
	public void setValue(Hashtable<String, Json> value) {
		this.value = value;
	}
	
	public void add(String key, Json value) {
		this.value.put(key, value);
	}
	
	public void setValue(HashMap<String, Json> value) {
		this.value = (Hashtable<String, Json>) value.clone();
	}
	
	public void clear() {
		this.value.clear();
	}
	
	public Hashtable<String, Json> getValues() {
		return (Hashtable<String, Json>) value.clone();
	}
	
	public Json getValue(String key) {
		return this.value.get(key);
	}
	
	@Override
	public String toString() {
		StringBuilder listContent = new StringBuilder();
		Set<String> keys = this.value.keySet();
		
		for(String key : keys) {
			Json val = this.value.get(key);
			listContent.append("\t");
			String str = ("" + val.toString()).replaceAll("\n", "\n\t");
			listContent.append("\"" + key + "\":" + str);
			listContent.append(",");
			listContent.append("\n");
		}
		return "{\n" + listContent + "}";
	}
}
