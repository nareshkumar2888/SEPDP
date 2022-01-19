package org.project;

public class Keyword {
	private int fid;
	private String words;
	private int len;
	private String owneremailid;
	private String filename;
	
	public String getOwneremailid() {
		return owneremailid;
	}
	public void setOwneremailid(String owneremailid) {
		this.owneremailid = owneremailid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
}
