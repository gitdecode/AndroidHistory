package com.example.android.bean;

public class ResponeMessage {
	
	private String title;

	private String img;
	
	private String month;
	
	private String year;
	
	private String day;
	
	@Override
	public String toString() {
		return "Message [title=" + title + ", img=" + img + ", month=" + month
				+ ", year=" + year + ", day=" + day + "]";
	}

	public ResponeMessage(String title, String img, String month, String year,
			String day) {
		super();
		this.title = title;
		this.img = img;
		this.month = month;
		this.year = year;
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
