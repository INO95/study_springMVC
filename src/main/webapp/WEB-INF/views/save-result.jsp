<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <%--반환 타입이 오브젝트 이기 때문에 Member 객체로 캐스팅 해야한다--%>
    <%--
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>username=<%=((Member)request.getAttribute("username")).getUsername()%></li>
    <li>age=<%=((Member)request.getAttribute("age")).getAge()%></li>
    --%>

    <%--jst에서 제공하는 표현식 : Property 접근법 (getter, setter를 호출)--%>
    <li>id=${member.id}</li>
    <li>id=${member.username}</li>
    <li>id=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
