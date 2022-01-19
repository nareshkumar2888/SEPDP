package org.project;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Blob;

public class DatasetAccess {
	Connection con;

	public DatasetAccess() throws ClassNotFoundException, SQLException {
		con = DBConnect.getconn();
	}

	public List<SharedFile> getDownloadDetails(String email, String status)
			throws SQLException {
		Statement stmt = con.createStatement();
		List<SharedFile> list = new ArrayList<>();
		ResultSet rs = stmt
				.executeQuery("select sid,sharedfiles.fid,useremailid,filekey,status,file.fname,file.owneremailid from sharedfiles inner join file on sharedfiles.fid=file.fid where useremailid='"
						+ email + "' and status='" + status + "'");
		while (rs.next()) {
			SharedFile files = new SharedFile();
			files.setSid(rs.getString(1));
			files.setFid(rs.getString(2));
			files.setUseremailid(rs.getString(3));
			files.setFilekey(rs.getString(4));
			files.setStatus(rs.getString(5));
			files.setFilename(rs.getString(6));
			files.setOwneremailid(rs.getString(7));
			list.add(files);
		}
		return list;
	}

	public List<SharedFile> reqFiles() throws SQLException {
		Statement stmt = con.createStatement();
		List<SharedFile> shared = new ArrayList<>();
		ResultSet rs = stmt
				.executeQuery("select sid,sharedfiles.fid,useremailid,status,file.fname,file.owneremailid from sharedfiles inner join file on sharedfiles.fid=file.fid where status='0'");
		while (rs.next()) {
			SharedFile sharedfile = new SharedFile();
			sharedfile.setSid(rs.getString(1));
			sharedfile.setFid(rs.getString(2));
			sharedfile.setUseremailid(rs.getString(3));
			sharedfile.setStatus(rs.getString(4));
			sharedfile.setFilename(rs.getString(5));
			sharedfile.setOwneremailid(rs.getString(6));
			shared.add(sharedfile);
		}
		return shared;
	}

	public void registerUser(User user) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.execute("Insert into reg (name,email,password,phone,city,usertype,status) values ('"
				+ user.getName()
				+ "','"
				+ user.getEmail()
				+ "','"
				+ user.getPassword()
				+ "','"
				+ user.getPhone()
				+ "','"
				+ user.getCity() + "','" + user.getUsertype() + "','0')");
	}

	public User getUserDetailsLogin(String email, String password,
			String usertype) throws SQLException {
		Statement stmt = con.createStatement();
		User user = new User();
		ResultSet rs = stmt
				.executeQuery("select name,email,usertype from reg where email = '"
						+ email
						+ "' and password = '"
						+ password
						+ "' and usertype = '" + usertype + "' and status='1'");
		while (rs.next()) {
			user.setName(rs.getString(1));
			user.setEmail(rs.getString(2));
			user.setUsertype(rs.getString(3));
		}
		return user;
	}

	public void updateViewSharedFile(String sid) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update sharedfiles set status='2' where sid = '"
				+ sid + "'");
	}

	public void reqAccept(String sid, String key) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update sharedfiles set status='1',filekey='" + key
				+ "' where sid = '" + sid + "'");
	}

	public void getActive(String email, String usertype) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update reg set status='1' where email = '" + email
				+ "' and usertype='" + usertype + "'");
	}

	public void getDeActive(String email, String usertype) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("update reg set status='0' where email = '" + email
				+ "' and usertype='" + usertype + "'");
	}

	public List<User> getAllDetails(String usertype) throws SQLException {
		Statement stmt = con.createStatement();
		List<User> list = new ArrayList<>();
		ResultSet rs = stmt
				.executeQuery("select name,email,phone,city,status,usertype from reg where usertype='"
						+ usertype + "'");
		while (rs.next()) {
			User user = new User();
			user.setName(rs.getString(1));
			user.setEmail(rs.getString(2));
			user.setPhone(rs.getString(3));
			user.setCity(rs.getString(4));
			user.setStatus(rs.getString(5));
			user.setUsertype(rs.getString(6));
			list.add(user);
		}
		return list;
	}

	public void fileUpload(String fid, String fname, InputStream inputStream,
			String email) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("insert into file(fid,fname,filedata,owneremailid) values(?, ?, AES_ENCRYPT(?, 'Tpfsdfdsfds4545'), ?)");
		ps.setString(1, fid);
		ps.setString(2, fname);
		ps.setBlob(3, inputStream);
		ps.setString(4, email);
		ps.executeUpdate();
	}
	
	public List<File> filesDetails() throws SQLException {
		Statement stmt = con.createStatement();
		List<File> list = new ArrayList<>();
		ResultSet rs = stmt
				.executeQuery("select file.fid,fname,owneremailid,signature from file inner join signature on file.fid=signature.fid");
		while (rs.next()) {
			File file = new File();
			file.setFid(rs.getString(1));
			file.setFilename(rs.getString(2));
			file.setOwneremailid(rs.getString(3));
			file.setSignature(rs.getString(4));
			list.add(file);
		}
		return list;
	}

	public void setSignature(String fid, String signature) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("insert into signature(fid,signature) values(?, ?)");
		ps.setString(1, fid);
		ps.setString(2, signature);
		ps.executeUpdate();
	}

	public void reqViewFile(String fid, String useremailid) throws SQLException {
		Statement stmt = con.createStatement();
		stmt.execute("Insert into sharedfiles (fid,useremailid,status) values ('"
				+ fid + "','" + useremailid + "','0')");
	}

	public Blob download(String fid, String filekey) throws SQLException {
		Blob b = null;
		PreparedStatement ps = con
				.prepareStatement("select AES_DECRYPT(filedata,'Tpfsdfdsfds4545') FROM file INNER JOIN sharedfiles ON sharedfiles.fid = file.fid where sharedfiles.filekey='"
						+ filekey + "' and file.fid='" + fid + "'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			b = (Blob) rs.getBlob(1);
		}
		return b;
	}
}
