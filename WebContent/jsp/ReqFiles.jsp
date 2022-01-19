<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SEPDP: Secure and Efficient</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/slider-styles.css" type="text/css"
	media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slider.js"></script>
</head>
<body class="ReqFiles">
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
	<div class="bottom-bg1">
		<div class="main-body">
			<div class="panel panel-default">
				<div class="panel-heading" style="color: #fff !important;">
					File Details</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>S1.No</th>
									<th>File Id</th>
									<th>File Name</th>
									<th>Owner EmailId</th>
									<th>User EmailId</th>
									<th>Generate Key</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sharedfiles}" var="details">
									<c:set var="count" value="${count + 1}" scope="page" />
									<tr class="odd gradeX">
										<td><c:out value="${count}" /></td>
										<td><c:out value="${details.fid}" /></td>
										<td><c:out value="${details.filename}" /></td>
										<td><c:out value="${details.owneremailid}" /></td>
										<td><c:out value="${details.useremailid}" /></td>
										<td><a
											href="${pageContext.request.contextPath}/secure?query=ReqAccept&sid=<c:out value="${details.sid}"/>"
											class="btn btn-primary">Generate Key</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>



