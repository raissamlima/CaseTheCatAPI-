package com.cat.api;

public class TheCatImages {
	
	private String id;
	private String breads;
	private String url;
	private int width;
	private int height;
	
	public TheCatImages(){
	}
	
	public TheCatImages(String id, String breads, String url, int width, int height){
		this.id = id;
		this.breads = breads;
		this.url = url;
		this.width = width;
		this.height = height;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBreads() {
		return breads;
	}
	public void setBreads(String breads) {
		this.breads = breads;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}