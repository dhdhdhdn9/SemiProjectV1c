<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- session.userid == null / session.userid == '' 
		=> empty session.userid로 작성 가능 -->
<c:if test="${empty sessionScope.userid}">
	<script>alert('로그인이 필요합니다!')
		location.href='/mvc/login'</script></c:if>

	<h1>회원정보</h1>

    <div id="myinfo">
        <div><span class="label">아이디</span>
             <span>${sessionScope.userid}</span>
        </div>

        <div><span class="label">이름</span>
             <span>${m.name}</span>
        </div>

        <div><span class="label">이메일</span>
             <span>${m.email}</span>
        </div>

        <div><span class="label">가입일</span>
             <span>${m.joindate}</span>
        </div>
    </div>
	            