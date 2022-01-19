<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String fid = request.getParameter("fid");
	String status = request.getParameter("status");
	String sid = request.getParameter("sid");
%>
<!DOCTYPE HTML>
<html>
<head>
<title>SEPDP: Secure and Efficient</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/slider-styles.css" type="text/css"
	media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/search.css">
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slider.js"></script>
</head>
<body class="Downloads">
	<div class="header">
		<div class="wrap">
			<%@include file="title.jsp"%>
			<div class="clear"></div>
		</div>
	</div>
	<div class="nav-wrap">
		<div class="wrap">
			<%@include file="menu.jsp"%>
		</div>
	</div>
	<div class="bottom-bg" style="padding: 11em !important;">
		<div class="main-body">
			<div id='container'>
				<form action="${pageContext.request.contextPath}/secure"
					method="post">
					<input type="hidden" name="source" value="FileKey" /> <input
						type="hidden" name="fid" value="<c:out value="${fid}"/>" /> <input
						type="hidden" name="sid" value="<c:out value="${sid}"/>" /> <input
						type="hidden" name="status" value="<c:out value="${status}"/>" />
					<div class='cell'>
						<input type='text' name="key" placeholder='enter file key'>
					</div>
					<div class='cell'>
						<div class='button' onchange="this.form.submit()">Press
							Enter</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>



