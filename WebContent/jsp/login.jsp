<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SEPDP: Secure and Efficient</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/slider-styles.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/form.css">
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
</head>
<body class="login">
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

			<div class="form">

				<ul class="tab-group">
					<li class="tab active"><a href="#signup">Sign Up</a></li>
					<li class="tab"><a href="#login">Log In</a></li>
				</ul>

				<div class="tab-content">
					<div id="signup">
						<c:set var="msg1" scope="session" value="Successfully Registered" />
						<c:if test="${msg=='success'}">
							<p class="msg">
								<c:out value="${msg1}" />
							</p>
						</c:if>
						<c:set var="msg1" scope="session" value="Invalid Credentials" />
						<c:if test="${msg=='invalid'}">
							<p class="msg1">
								<c:out value="${msg1}" />
							</p>
						</c:if>
						<h1
							style="text-align: center; color: #ffffff; font-weight: 300; margin: 0 0 40px;">Sign
							Up for Free</h1>

						<form action="${pageContext.request.contextPath}/secure"
							method="post">

							<input type="hidden" name="source" value="Register" />

							<div class="field-wrap">
								<label> Name<span class="req">*</span>
								</label> <input type="text" name="name" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Email Address<span class="req">*</span>
								</label> <input type="email" name="email" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Set A Password<span class="req">*</span>
								</label> <input type="password" name="password" required
									autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Phone<span class="req">*</span>
								</label> <input type="number" name="phone" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> City<span class="req">*</span>
								</label> <input type="text" name="city" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<select name="usertype">
									<option value="owner">Data Owner</option>
									<option value="user">User</option>
								</select>
							</div>
							<button type="submit" class="button button-block" />
							Register
							</button>
						</form>
					</div>
					<div id="login">
						<h1
							style="text-align: center; color: #ffffff; font-weight: 300; margin: 0 0 40px;">Welcome
							Back!</h1>
						<form action="${pageContext.request.contextPath}/secure"
							method="post">
							<div class="field-wrap">
								<label> Email Address<span class="req">*</span>
								</label> <input type="email" name="email" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Password<span class="req">*</span>
								</label> <input type="password" name="password" required
									autocomplete="off" />
							</div>
							<input type="hidden" name="source" value="Login" />
							<div class="field-wrap">
								<select name="usertype">
									<option value="csp">CSP</option>
									<option value="tpa">TPA</option>
									<option value="owner">Data Owner</option>
									<option value="user">User</option>
								</select>
							</div>
							<button class="button button-block" />
							Log In
							</button>
						</form>
					</div>
				</div>
				<!-- tab-content -->
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	<script src="js/jquery.min.js"></script>
	<script src="js/index.js"></script>
</body>
</html>
