<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-07-23
  Time: PM 2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div>
    <jsp:include page="${pageContext.request.contextPath}/header.jsp"></jsp:include>
    <main>
        <div class="container mt-5 w-25">
            <h4>로그인</h4>
        </div>
        <div class="container mt-4 mb-5 w-25">
            <form id="loginForm" action="/user/login.do" method="post">
                <div class="form-group">
                    <label for="username">아이디</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="form-group mt-4">
                    <label for="password">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="form-group mt-4">
                    <button type="submit" class="btn btn-outline-secondary w-100">로그인</button>
                </div>
            </form>
        </div>
    </main>
    <jsp:include page="${pageContext.request.contextPath}/footer.jsp"></jsp:include>

</div>
</body>
</html>
