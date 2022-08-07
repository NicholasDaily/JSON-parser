package com.unitedhuskies.json;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;


public class JsonParser {
	private ArrayList<Json> parsedJson = new ArrayList<>();
	private Scanner fileData;
	int numCode = 0;

	JsonParser(Scanner input) throws FileNotFoundException{
		fileData = input;
		fileData.useDelimiter("");
	}
	int i = 0;
	public ArrayList<Json> parseJson() throws IOException{
		while(numCode != -1) {
			Json obj = processChars();
			if(obj != null) {
				parsedJson.add(obj);
			}
		}
		return parsedJson;
	}

	private Json processChars() throws IOException {
		StringBuilder jsonFragment = new StringBuilder();
		char c;
		
		while(fileData.hasNext()) {
			numCode = fileData.next().charAt(0);
			
			c = (char)numCode;
			switch(c) {
				case '"':
					return formString();
				case '{':
					return formObject();
				case '[':
					return formList();
				case '}':
				case ']':
					if(!jsonFragment.isEmpty())
						return formPrimitiveJson(jsonFragment.toString());
					else {
						return null;
					}
				case ' ':
				case '\t':
				case '\r':
				case ',':
					if(!jsonFragment.isEmpty())
						return formPrimitiveJson(jsonFragment.toString());
					break;
				default:
					if(Character.isLetter(c) || Character.toString(c).matches("^([+-]?\\d*\\.?\\d*)$"))
						jsonFragment.append(c);
			}
		}
		this.numCode = -1;
		if(!jsonFragment.isEmpty())
			return formPrimitiveJson(jsonFragment.toString());
		else
			return null;
	}
	
	private Json formPrimitiveJson(String json) {
		Json prim;
		if(json.equals("true")) {
			prim = new JsonBoolean(true);
		}else if(json.equals("false")) {
			prim = new JsonBoolean(false);
		}else if(json.equals("null")){
			prim = new JsonNull();
		}else if(json.matches("^([+-]?\\d*\\.?\\d*)$")){
			if(json.contains("."))
				prim = new JsonDouble(Double.parseDouble(json));
			else
				prim = new JsonInt(Integer.parseInt(json));
		}else {
			prim = new JsonString("COULD NOT BE CONVERTED");
		}
		return prim;
	}
	
	private JsonObject formObject() throws IOException {
		JsonObject obj = new JsonObject();
		String key = "";
		while(true) {
			Json val = processChars();
			if(val == null) {
				numCode=69;
				break;
			}else if(val != null && (char) numCode == '}' ) {
				numCode=69;
				obj.add(key, val);
				break;
			}
			else {
				if(key.equals("") && val instanceof JsonString)
					key = val.toString().replace("\"", "");
				else {
					obj.add(key, val);
					key="";
				}
			}
		}
		return obj;
	}
	
	private JsonList formList() throws IOException {
		JsonList list = new JsonList();
		
		while(true) {
			Json val = processChars();
			if(val == null) {
				numCode=69;
				break;
			}else if(val != null && (char) numCode == ']' ) {
				numCode=69;
				list.add(val);
				break;
			}
			else {
				list.add(val);
			}
		}
		return list;
	}
	
	private JsonString formString() throws IOException {
		JsonString string = new JsonString();
		StringBuilder str = new StringBuilder();
		numCode = 69;
		while(fileData.hasNext() && (char) numCode != '"') {
			numCode = fileData.next().charAt(0);
			if(((char) numCode) == '"')
				break;
			str.append((char) numCode);
		}
		string.setValue("" + str);
		return string;
	}
	
	
}
