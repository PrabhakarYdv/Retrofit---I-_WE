package com.prabhakar.myapplication;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class SupportDTO implements Serializable {

	@SerializedName("url")
	private String url;

	@SerializedName("text")
	private String text;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"SupportDTO{" + 
			"url = '" + url + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}