package org.project;

public class File {

	private String fid;
	private String owneremailid;
	private String filename;
	private String signature;

	public final String getSignature() {
		return signature;
	}

	public final void setSignature(String signature) {
		this.signature = signature;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

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
}
