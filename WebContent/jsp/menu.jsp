<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="nav">
	<ul>
		<c:if test="${empty auth }">
			<li class="home"><a
				href="${pageContext.request.contextPath}/secure?query=Home">Home</a></li>
			<li class="Register"><a
				href="${pageContext.request.contextPath}/secure?query=Register">Registration
					/ Login</a></li>
			<div class="clear"></div>
		</c:if>
		<c:if test="${auth=='user' }">
			<li class="userHome"><a
				href="${pageContext.request.contextPath}/secure?query=Home">Home</a></li>
			<li class="searchFiles"><a
				href="${pageContext.request.contextPath}/secure?query=Search">Search
					Files</a></li>
			<li class="download"><a
				href="${pageContext.request.contextPath}/secure?query=Download">Download</a></li>
			<li><a
				href="${pageContext.request.contextPath}/secure?query=Logout">Logout</a></li>
			<div class="clear"></div>
		</c:if>
		<c:if test="${auth=='owner' }">
			<li class="ownerHome"><a
				href="${pageContext.request.contextPath}/secure?query=Home">Home</a></li>
			<li class="Upload"><a
				href="${pageContext.request.contextPath}/secure?query=Upload">Upload</a></li>
			<li><a
				href="${pageContext.request.contextPath}/secure?query=Logout">Logout</a></li>
			<div class="clear"></div>
		</c:if>
		<c:if test="${auth=='csp' }">
			<li class="authorityHome"><a
				href="${pageContext.request.contextPath}/secure?query=Home">Home</a></li>
			<li class="allOwners"><a
				href="${pageContext.request.contextPath}/secure?query=AllOwners">All
					Owners</a></li>
			<li class="allUsers"><a
				href="${pageContext.request.contextPath}/secure?query=AllUsers">All
					Users</a></li>
			<li class="files"><a
				href="${pageContext.request.contextPath}/secure?query=Files">
					Files </a></li>
			<li class="ReqFiles"><a
				href="${pageContext.request.contextPath}/secure?query=ReqFiles">Requested
					Files </a></li>
			<li><a
				href="${pageContext.request.contextPath}/secure?query=Logout">Logout</a></li>
			<div class="clear"></div>
		</c:if>
		<c:if test="${auth=='tpa' }">
			<li class="ownerHome"><a
				href="${pageContext.request.contextPath}/secure?query=Home">Home</a></li>
			<li class="ReqFiles"><a
				href="${pageContext.request.contextPath}/secure?query=ReqFiles">Requested
					Files </a></li>
			<li><a
				href="${pageContext.request.contextPath}/secure?query=Logout">Logout</a></li>
			<div class="clear"></div>
		</c:if>
	</ul>
</div>