<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="soonj.jdbc"/>
<fmt:message key="url" var="url"/>
<fmt:message key="drv" var="drv"/>
<fmt:message key="usr" var="usr"/>
<fmt:message key="pwd" var="pwd"/>

<fmt:requestEncoding value="UTF-8"/>

<sql:setDataSource url="${url}" driver="${drv}" user="${usr}" password="${pwd}"
	var="mariadb"/>
	
<sql:query var="rs" dataSource="${mariadb}">
	select bdno, userid, title, regdate, thumbup, views from board order by bdno desc </sql:query>
	
	
	<h1>게시판</h1>
    <table>
        <colgroup> <!-- 테이블 컬럼 스타일 정의 -->
			<col style="width: 10%">
			<col style="">
			<col style="width: 15%">
			<col style="width: 15%">
			<col style="width: 10%">
			<col style="width: 10%">
		</colgroup>
		<thead>
		    <tr>
		        <td colspan="6" class="newbtn">
		        <c:if test="${empty sessionScope.userid}">
				&nbsp;</c:if>
				<c:if test="${not empty sessionScope.userid}">
				<button type="button" id="newbtn">글쓰기</button></c:if></td>
		    </tr>
		    <tr>
		        <td>번호</td>
		        <td>제목</td>
		        <td>작성자</td>
		        <td>작성일</td>
		        <td>추천</td>
		        <td>조회</td>
		    </tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="r" items="${rs.rows}" varStatus="no">
					<tr><td>${no.count}</td>
						<td><a href="/mvc/board/view?bdno=${r.bdno}">${r.title}</a></td>
						<td>${r.userid}</td>
						<td><fmt:formatDate value="${r.regdate}" type="date"></fmt:formatDate></td>
						<td>${r.thumbup}</td>
						<td>${r.views}</td>
					</tr>
				</c:forEach>
		  	</tr>
		</tbody>	
		
	    <tfoot>
	        <tr><td colspan="6" class="tbnav">
	            <span>◁ ◀◀ <span class="cpage">1</span> 2 3 4 5 6 7 8 9 10 ▶▶ ▷</span>
	            </td></tr>
	    </tfoot>
	
	</table>

        
	<script>
		var newbtn = document.getElementById('newbtn');
		newbtn.addEventListener('click', write);
		
		function write(){
			location.href='/board/write.jsp'
		}
	</script>
