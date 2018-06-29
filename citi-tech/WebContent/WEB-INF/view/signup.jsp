<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Inshann Sign Up Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">

<style>
body {
	background-image: url("<c:url value='/resources/img/bric.png'/>");
	background-attachment: inherit;
}
</style>

<script>
	function checkLengthPassword() {
		var takeValue = document.getElementById("pwd").value;
		document.getElementById("msg").innerHTML = "";

		if (takeValue.length < 8) {
			document.getElementById("pw").innerHTML = "Password Length Should be atleast 8 Character";
		} else {
			document.getElementById("pw").innerHTML = "";
		}
	}

	function checkPassword() {
		var passwordValue = document.getElementById("pwd").value;
		var checkPasswordValue = document.getElementById("cpwd").value;

		if (passwordValue.length != checkPasswordValue.length) {
			document.getElementById("pw").innerHTML = "Your confirm password is not mathching with password";
			document.getElementById("button").disable = true;
		} else if (passwordValue.length == checkPasswordValue.length) {

			if (passwordValue == checkPasswordValue) {
				document.getElementById("pw").innerHTML = "";
			} else {
				document.getElementById("pw").innerHTML = "Your confirm password is not mathching with password";
				document.getElementById("button").disable = true;
			}

		} else {
			document.getElementById("pw").innerHTML = " ";
			document.getElementById("button").disable = false;
		}
	}
</script>

</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-offset-4">
				<div style="margin-left: 60px">
					<p id="msg"
						style="color: red; font-size: 17px; font-family: monospace; font-weight: bold">${msg}</p>
				</div>
				<div style="margin-left: 10px">
					<p id="pw"
						style="color: red; font-size: 17px; font-family: monospace; font-weight: bold"></p>
				</div>
				<div style="margin-left: 10px">
					<p id="eml"
						style="color: red; font-size: 17px; font-family: monospace;"></p>
				</div>
			</div>

		</div>

		<div class="row">

			<div class="im" style="margin-top: 80px;">
				<img src="<c:url value='/resources/img/log1.png' />"
					class="img-responsive img-circle center-block">
			</div>
			<div class="col-md-4 col-md-offset-4" style="margin-top: 10px">

				<div>
					<c:url var="get" value="/user/insertUserDetails"></c:url>
					<form:form action="${get}" modelAttribute="userDetails"
						method="POST">
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-user"></span></span> <input type="text"
								name="userName" id="userName" class="form-control"
								placeholder="USERNAME" required="required"
								value="${usermanagement.userName}">
						</div>

						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-envelope"></span></span> <input type="email"
								name="emailId" class="form-control" placeholder="EMAIL-ID"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
								required="required" value="${usermanagement.emailId}">
						</div>

						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-lock"></span></span> <input type="password"
								name="password" id="pwd" min="8" class="form-control"
								placeholder="PASSWORD" required="required"
								onkeyup="checkLengthPassword();">
						</div>

						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-lock"></span></span> <input type="password"
								name="confirmPassword" id="cpwd" min="8" class="form-control"
								placeholder="CONFIRM PASSWORD" required="required"
								onkeyup="checkPassword();">
						</div>

						<div style="margin-top: 10px">
							<button type="submit" value="Sign up" class="btn-block"
								id="button" name="action">Sign up</button>
						</div>
					</form:form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>