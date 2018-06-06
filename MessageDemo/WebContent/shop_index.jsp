<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商家平台界面</title>
<style type="text/css">
	.ifream1{
		frameborder:0px;
		width:100px;
		height:100px;
		background-color: red;
	}
</style>
<script src="http://code.jquery.com/jquery-1.2.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		 $("#stop").click(function(){ 
			 $.ajax({
				url:'Servlet?method=stop',
				type:'POST',
				data:{},
				dataType:'text',
				success:function(data){
					//console.log(data);
					if(data=='true'){
						alert("成功！");
						return;
					}else{
	          			alert("错误！");
					}
				}
			});
		 });
	});
</script>
</head>
<body style="align-items:center;">
<div>
	<iframe class="ifream1" src="message.jsp"></iframe>
	<br/>
	<input id="stop" value="停止" type="button">
</div>
</body>
</html>