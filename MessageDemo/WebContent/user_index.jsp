<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户操作界面</title>

<script src="http://code.jquery.com/jquery-1.2.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		 $("#submit").click(function(){ 
			 $.ajax({
				url:'Servlet?method=submit',
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
<body>
	
	按这个按钮模拟用户下单<br>
	<input type="submit" id="submit" value="下单">
	
</body>
</html>