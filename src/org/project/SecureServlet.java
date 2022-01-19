package org.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Blob;

@MultipartConfig(maxFileSize = 16177215)
public class SecureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		if ("Home".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Register".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/login.jsp");
					view.forward(request, response);
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Upload".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String email = user.getEmail();
					String usertype = user.getUsertype();
					String name = user.getName();
					request.setAttribute("name", name);
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/Upload.jsp");
					view.forward(request, response);
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("DataOwnerActive".equals(query)
				|| "UserActive".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String emails = request.getParameter("email");
					String usertypes = request.getParameter("usertype");
					List<User> details = new ArrayList<>();
					List<User> users = new ArrayList<>();
					RequestDispatcher view = null;
					DatasetAccess access = new DatasetAccess();
					access.getActive(emails, usertypes);
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					if (query.equals("DataOwnerActive")) {
						usertype = "owner";
						users = access.getAllDetails(usertype);
						details.addAll(users);
						request.setAttribute("details", details);
						view = request
								.getRequestDispatcher("jsp/AllDataOwners.jsp");
					}
					if (query.equals("UserActive")) {
						usertype = "user";
						users = access.getAllDetails(usertype);
						details.addAll(users);
						request.setAttribute("details", details);
						view = request.getRequestDispatcher("jsp/AllUsers.jsp");
					}
					view.forward(request, response);
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Download".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					List<SharedFile> details = new ArrayList<>();
					List<SharedFile> files = new ArrayList<>();
					DatasetAccess access = new DatasetAccess();
					String status = "1";
					String email = user.getEmail();
					String usertype = user.getUsertype();
					files = access.getDownloadDetails(email, status);
					details.addAll(files);
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					request.setAttribute("reqdetails", details);
					view = request.getRequestDispatcher("jsp/Download.jsp");
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Downloads".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String fid = request.getParameter("fid");
					String sid = request.getParameter("sid");
					String status = request.getParameter("status");
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					request.setAttribute("fid", fid);
					request.setAttribute("status", status);
					request.setAttribute("sid", sid);
					view = request.getRequestDispatcher("jsp/Downloads.jsp");
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("ReqFiles".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					DatasetAccess access = new DatasetAccess();
					List<SharedFile> details = new ArrayList<>();
					List<SharedFile> file = new ArrayList<>();
					file = access.reqFiles();
					details.addAll(file);
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					request.setAttribute("sharedfiles", details);
					view = request.getRequestDispatcher("jsp/ReqFiles.jsp");
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("ReqAccept".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					UUID uuid = UUID.randomUUID();
					String keys = uuid.toString();
					String key = keys.substring(0, 5);
					String sid = request.getParameter("sid");
					DatasetAccess access = new DatasetAccess();
					List<SharedFile> details = new ArrayList<>();
					List<SharedFile> file = new ArrayList<>();
					access.reqAccept(sid, key);
					file = access.reqFiles();
					details.addAll(file);
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					request.setAttribute("sharedfiles", details);
					view = request.getRequestDispatcher("jsp/ReqFiles.jsp");
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Files".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					DatasetAccess access = new DatasetAccess();
					List<File> details = new ArrayList<>();
					List<File> file = new ArrayList<>();
					file = access.filesDetails();
					details.addAll(file);
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					request.setAttribute("details", details);
					view = request.getRequestDispatcher("jsp/File.jsp");
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Search".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					DatasetAccess access = new DatasetAccess();
					List<File> details = new ArrayList<>();
					List<File> file = new ArrayList<>();
					file = access.filesDetails();
					details.addAll(file);
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					request.setAttribute("details", details);
					view = request.getRequestDispatcher("jsp/SearchData.jsp");
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("ReqViewFiles".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String email = user.getEmail();
					String usertype = user.getUsertype();
					String fid = request.getParameter("fid");
					DatasetAccess access = new DatasetAccess();
					access.reqViewFile(fid, email);
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					response.sendRedirect(request.getContextPath()
							+ "/secure?query=Search");
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("DataOwnerDeActive".equals(query)
				|| "UserDeActive".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String emails = request.getParameter("email");
					String usertypes = request.getParameter("usertype");
					List<User> details = new ArrayList<>();
					List<User> users = new ArrayList<>();
					RequestDispatcher view = null;
					DatasetAccess access = new DatasetAccess();
					access.getDeActive(emails, usertypes);
					String email = user.getEmail();
					String usertype = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertype);
					if (query.equals("DataOwnerDeActive")) {
						usertype = "owner";
						users = access.getAllDetails(usertype);
						details.addAll(users);
						request.setAttribute("details", details);
						view = request
								.getRequestDispatcher("jsp/AllDataOwners.jsp");
					}
					if (query.equals("UserDeActive")) {
						usertype = "user";
						users = access.getAllDetails(usertype);
						details.addAll(users);
						request.setAttribute("details", details);
						view = request.getRequestDispatcher("jsp/AllUsers.jsp");
					}
					view.forward(request, response);
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("AllOwners".equals(query) || "AllUsers".equals(query)) {
			try {
				String usertype = "";
				HttpSession session = request.getSession(false);
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/login.jsp");
					view.forward(request, response);
				} else {
					DatasetAccess access = new DatasetAccess();
					RequestDispatcher view = null;
					String email = user.getEmail();
					String usertypes = user.getUsertype();
					request.setAttribute("email", email);
					request.setAttribute("auth", usertypes);
					List<User> details = new ArrayList<>();
					List<User> users = new ArrayList<>();
					if (query.equals("AllOwners")) {
						usertype = "owner";
						users = access.getAllDetails(usertype);
						details.addAll(users);
						request.setAttribute("details", details);
						view = request
								.getRequestDispatcher("jsp/AllDataOwners.jsp");
					}
					if (query.equals("AllUsers")) {
						usertype = "user";
						users = access.getAllDetails(usertype);
						details.addAll(users);
						request.setAttribute("details", details);
						view = request.getRequestDispatcher("jsp/AllUsers.jsp");
					}
					view.forward(request, response);
				}
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} else if ("Logout".equals(query)) {
			try {
				HttpSession session = request.getSession(false);
				if (session != null)
					session.invalidate();
				RequestDispatcher view = request
						.getRequestDispatcher("jsp/index.jsp");
				view.forward(request, response);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		if ("Register".equals(source)) {
			try {
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String password = request.getParameter("password");
				String city = request.getParameter("city");
				String usertype = request.getParameter("usertype");
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhone(phone);
				user.setCity(city);
				user.setUsertype(usertype);
				DatasetAccess access = new DatasetAccess();
				access.registerUser(user);
				request.setAttribute("msg", "success");
				RequestDispatcher view = request
						.getRequestDispatcher("jsp/login.jsp");
				view.forward(request, response);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if ("Login".equals(source)) {
			try {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String usertype = request.getParameter("usertype");
				DatasetAccess access = new DatasetAccess();
				User user = new User();
				user = access.getUserDetailsLogin(email, password, usertype);
				if ("".equals(user.getEmail()) || user.getEmail() == null) {
					request.setAttribute("msg", "invalid");
					RequestDispatcher view = request
							.getRequestDispatcher("jsp/login.jsp");
					view.forward(request, response);
				} else {
					HttpSession session = request.getSession(true);
					session.setAttribute("User", user);
					response.sendRedirect(request.getContextPath()
							+ "/secure?query=Home");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if ("Upload".equals(source)) {
			HttpSession session = request.getSession(false);
			UUID uuid = UUID.randomUUID();
			String random = (uuid.toString()).substring(0, 5);
			User user = new User();
			user = (User) session.getAttribute("User");
			String fname = request.getParameter("fname");
			DatasetAccess access;
			InputStream inputStream = null;
			Part filePart = request.getPart("filedata");
			String filepath = getFileName(filePart);
			String st = FilePath.filePath() + filepath;
			inputStream = filePart.getInputStream();
			try {
				access = new DatasetAccess();
				String email = user.getEmail();
				String usertype = user.getUsertype();
				access.fileUpload(random, fname, inputStream, email);
				String signature = Signature.main(st);
				access.setSignature(random, signature);
				request.setAttribute("email", email);
				request.setAttribute("auth", usertype);
				request.setAttribute("msg", "success");
				RequestDispatcher view = request
						.getRequestDispatcher("jsp/Upload.jsp");
				view.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("FileKey".equals(source)) {
			try {
				HttpSession session = request.getSession(false);
				String msg = "";
				RequestDispatcher view = null;
				User user = new User();
				user = (User) session.getAttribute("User");
				if (user == null || user == null || "".equals(user.getEmail())) {
					view = request.getRequestDispatcher("jsp/index.jsp");
					view.forward(request, response);
				} else {
					String fid = request.getParameter("fid");
					String sid = request.getParameter("sid");
					String filekey = request.getParameter("key").trim();
					List<SharedFile> details = new ArrayList<>();
					List<SharedFile> files = new ArrayList<>();
					Blob b = null;
					DatasetAccess access = new DatasetAccess();
					String email = user.getEmail();
					String usertype = user.getUsertype();
					int accept = 0;
					if ("FileKey".equals(source)) {
						b = access.download(fid, filekey);
						// Blob b = (Blob)session.getAttribute("resumeBlob");
						if (b != null) {
							accept = 1;
							String fileName = "SharedFile.txt";
							byte[] ba = b.getBytes(1, (int) b.length());
							response.setContentType("text");
							response.setHeader("Content-Disposition",
									"attachment; fileName=\"" + fileName + "\"");
							OutputStream os = response.getOutputStream();
							os.write(ba);
							os.close();
							ba = null;
							msg = "success";
						}
					}
					if (accept == 0) {
						access.updateViewSharedFile(sid);
						String status = "1";
						files = access.getDownloadDetails(email, status);
						details.addAll(files);
						request.setAttribute("msg", msg);
						request.setAttribute("email", email);
						request.setAttribute("auth", usertype);
						request.setAttribute("reqdetails", details);
						view = request.getRequestDispatcher("jsp/Download.jsp");
					} else {
						access.updateViewSharedFile(sid);
						String status = "1";
						files = access.getDownloadDetails(email, status);
						details.addAll(files);
						request.setAttribute("msg", msg);
						request.setAttribute("email", email);
						request.setAttribute("auth", usertype);
						request.setAttribute("reqdetails", details);
						view = request.getRequestDispatcher("jsp/Download.jsp");
					}
				}
				view.forward(request, response);
			} catch (Exception ae) {
				System.out.println(ae);
			}
		} 
	}

	private String getFileName(Part filepart) {
		for (String cd : filepart.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
