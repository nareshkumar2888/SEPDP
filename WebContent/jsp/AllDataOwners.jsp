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
<body class="AllDataOwners">
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
					Data Owner Details</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>Sl.No</th>
									<th>Data Owner Name</th>
									<th>Email Id</th>
									<th>Mobile</th>
									<th>City</th>
									<th>Status</th>
									<th>Active</th>
									<th>De-Active</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${details}" var="details">
									<c:set var="count" value="${count + 1}" scope="page" />
									<tr class="odd gradeX">
										<td><c:out value="${count}" /></td>
										<td><c:out value="${details.name}" /></td>
										<td><c:out value="${details.email}" /></td>
										<td><c:out value="${details.phone}" /></td>
										<td><c:out value="${details.city}" /></td>
										<c:if test="${details.status=='0'}">
											<td><c:out value="${'De-Active'}" /></td>
										</c:if>
										<c:if test="${details.status=='1'}">
											<td><c:out value="${'Active'}" /></td>
										</c:if>
										<td><a
											href="${pageContext.request.contextPath}/secure?query=DataOwnerActive&email=<c:out value="${details.email}"/>&&usertype=<c:out value="${details.usertype}"/>"
											class="btn btn-success">Active</a></td>
										<td><a
											href="${pageContext.request.contextPath}/secure?query=DataOwnerDeActive&email=<c:out value="${details.email}"/>&&usertype=<c:out value="${details.usertype}"/>"
											class="btn btn-danger">De-Active</a></td>
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

