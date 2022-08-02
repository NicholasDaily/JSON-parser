package com.unitedhuskies.json;

import java.util.ArrayList;

public class JsonObject extends Json {
	
	private ArrayList<Json> value = new ArrayList<>();
	
	JsonObject(){
		super(JsonType.OBJECT);
	}
	
	JsonObject(String key){
		super(key, JsonType.OBJECT);
	}
	
	JsonObject(ArrayList<Json> value){
		super(JsonType.OBJECT);
		this.value = value;
	}
	
	JsonObject(ArrayList<Json> value, String key){
		super(key, JsonType.OBJECT);
		this.value = (ArrayList<Json>) value.clone();
	}
	
	public void setValue(ArrayList<Json> value) {
		this.value = value;
	}
	
	public void add(Json ... item) {
		for(int i = 0; i < item.length; i++) {
			this.value.add(item[i]);
		}
	}
	
	public void setValue(Json ... item) {
		clear();
		add(item);
	}
	
	public void clear() {
		this.value.clear();
	}
	
	public ArrayList<Json> getValue() {
		return (ArrayList<Json>) value.clone();
	}
	
	public Json getValue(String key) {
		for(Json x : value) {
			if(key.equals(x.getKey())) {
				return x;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder listContent = new StringBuilder();
		ArrayList<String> keys = new ArrayList<>();
		
		for(int i = 0; i < this.value.size(); i++) {
			Json x = this.value.get(i);
			if(!x.getKey().equals("") && !x.toString().equals("")){
				if(keys.contains(x.getKey())) continue;
				listContent.append("\t");
				if(x.getType() == JsonType.OBJECT) {
					 String str = ("" + x).replaceAll("\n", "\n\t");
					 listContent.append("\"" + x.getKey() + "\":" + str);
				}else {
					listContent.append("\"" + x.getKey() + "\":" + x);
				}
				if(i != this.value.size() - 1) listContent.append(",");
				listContent.append("\n");
				keys.add(x.getKey());
			}
			
		}
		return "{\n" + listContent + "}";
	}
}
