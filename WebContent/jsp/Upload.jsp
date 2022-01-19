<!DOCTYPE HTML>
<html>
<head>
<title>SEPDP: Secure and Efficient</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/slider-styles.css" type="text/css"
	media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/upload.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/slider.js"></script>
</head>
<body class="Upload">
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
	<div class="bottom-bg2">
		<div class="main-body"></div>
		<div class="upload">
			<h3>Select File</h3>
			<div class="login-form">
				<c:set var="msg1" scope="session"
					value="Successfully Your File Have Been Uploaded" />
				<c:if test="${msg=='success'}">
					<p class="msg">
						<c:out value="${msg1}" />
					</p>
					<br>
				</c:if>

				<form id="upload" method="post"
					action="${pageContext.request.contextPath}/secure"
					enctype="multipart/form-data">
					<input type="hidden" name="source" value="Upload">

					<div>
						<span><strong>File Name</strong></span> <input type="text"
							class="title" name="fname" value="Eg: Beach Fun"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Eg: Beach Fun';}" />
					</div>

					<div id="drop">
						<a>Upload</a> <input type="file" name="filedata"
							onchange="this.form.submit()" />
					</div>

					<ul>

					</ul>

				</form>
			</div>

			<!-- JavaScript Includes -->
			<script src="js/jquery.knob.js"></script>
			<!-- JavaScript Includes -->

			<!-- jQuery File Upload Dependencies -->
			<script src="js/jquery.ui.widget.js"></script>
			<script src="js/jquery.iframe-transport.js"></script>
			<script src="js/jquery.fileupload.js"></script>
			<!-- jQuery File Upload Dependencies -->

			<!-- Main JavaScript file -->
			<script src="js/script.js"></script>
			<!-- Main JavaScript file -->

		</div>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
