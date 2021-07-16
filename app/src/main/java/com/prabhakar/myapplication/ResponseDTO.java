package com.prabhakar.myapplication;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseDTO implements Serializable {

	@SerializedName("data")
	private DataDTO data;

	@SerializedName("support")
	private SupportDTO support;

	public void setData(DataDTO data){
		this.data = data;
	}

	public DataDTO getData(){
		return data;
	}

	public void setSupport(SupportDTO support){
		this.support = support;
	}

	public SupportDTO getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}