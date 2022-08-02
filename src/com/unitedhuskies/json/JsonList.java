package com.unitedhuskies.json;

import java.util.ArrayList;

public class JsonList extends Json {
	
	private ArrayList<Json> value = new ArrayList<>();
	
	JsonList(){
		super(JsonType.LIST);
	}
	
	JsonList(String key){
		super(key, JsonType.LIST);
	}
	
	JsonList(ArrayList<Json> value){
		super(JsonType.LIST);
		this.value = value;
	}
	
	JsonList(ArrayList<Json> value, String key){
		super(key, JsonType.LIST);
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
	
	@Override
	public String toString() {
		StringBuilder listContent = new StringBuilder();
		
		for(int i = 0; i < this.value.size(); i++) {
			Json x = this.value.get(i);
			listContent.append("" + x);
			if(i < this.value.size() - 1) 
				listContent.append(", ");
			
		}
		return "[" + listContent + "]";
	}
}
