package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FactsItem{

	@JsonProperty("upvotes")
	private Integer upvotes;

	@JsonProperty("id")
	private String id;

	@JsonProperty("text")
	private String text;

	@JsonProperty("type")
	private String type;

	@JsonProperty("user")
	private String user;

	public Integer getUpvotes(){
		return upvotes;
	}

	public String getId(){
		return id;
	}

	public String getText(){
		return text;
	}

	public String getType(){
		return type;
	}

	public String getUser(){
		return user;
	}

	@Override
	public String toString() {
		return "FactsItem{" +
				"upvotes=" + upvotes +
				", id='" + id + '\'' +
				", text='" + text + '\'' +
				", type='" + type + '\'' +
				", user='" + user + '\'' +
				'}';
	}
}