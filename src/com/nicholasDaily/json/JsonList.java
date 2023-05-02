package com.nicholasDaily.json;

import java.util.ArrayList;

public class JsonList extends Json {
	
	private ArrayList<Json> value = new ArrayList<>();
	
	JsonList(){
		super(JsonType.LIST);
	}
	
	
	JsonList(ArrayList<Json> value){
		super(JsonType.LIST);
		this.value = value;
	}
	
	
	public void setValue(ArrayList<Json> value) {
		this.value = value;
	}
	
	public void add(Json ... item) {
		for(int i = 0; i < item.length; i++) {
			this.value.add(item[i]);
		}
	}
	
	public void setValues(Json ... item) {
		clear();
		add(item);
	}
	
	public void setValue(int index, Json value) {
		this.value.add(index, value);
	}
	
	public void clear() {
		this.value.clear();
	}
	
	public ArrayList<Json> getValues() {
		return (ArrayList<Json>) value.clone();
	}
	
	public Json get(int index) {
		return value.get(index);
	}
	
	public int size() {
		return value.size();
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
