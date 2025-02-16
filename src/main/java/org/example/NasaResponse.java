package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaResponse{

	@JsonProperty("date")
	private String date;

	@JsonProperty("copyright")
	private String copyright;

	@JsonProperty("media_type")
	private String mediaType;

	@JsonProperty("hdurl")
	private String hdurl;

	@JsonProperty("service_version")
	private String serviceVersion;

	@JsonProperty("explanation")
	private String explanation;

	@JsonProperty("title")
	private String title;

	@JsonProperty("url")
	private String url;

	public String getDate(){
		return date;
	}

	public String getCopyright(){
		return copyright;
	}

	public String getMediaType(){
		return mediaType;
	}

	public String getHdurl(){
		return hdurl;
	}

	public String getServiceVersion(){
		return serviceVersion;
	}

	public String getExplanation(){
		return explanation;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}
}