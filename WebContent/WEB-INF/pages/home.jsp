<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/pages/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>monitor</title>
</head>
<body id="home_body">
hellow
<script type="text/javascript"  src="${ctx}/scripts/jquery-1.11.1.min.js"></script>
 <script type="text/javascript">
	$(function(){
		$.ajax({
			   type: "post",
			   url: 'http://121.40.112.242:8080/monitor/hostInfo/list',
			   dataType:'jsonp',
			   jsonp: "callback",
			   success: function(msg){
			       console.log( msg); 
			   }
			});
	});
 </script>
</body>
</html>