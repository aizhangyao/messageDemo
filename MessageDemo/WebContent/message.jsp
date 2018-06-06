<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>消息监听</title>
<script src="http://code.jquery.com/jquery-1.2.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		setInterval(function() {
			$.ajax({
				url:'Servlet?method=listen',
				type:'POST',
				data:{},
				dataType:'text',
				success:function(data){
					//console.log(data);
					if(data=='true'){
						play();
						return;
					}else{
						//
						$('#newMessageDIV').html("没有订单");
					}
				}
			})
		},1000);
	});
	
	function play() {
		if($.browser.msie && $.browser.version == '8.0') {
			$('#newMessageDIV').html('<embed src="audio/10111.wav"/>');
		}else{
			//IE9+,Firefox,Chrome均支持<audio/>   
			$('#newMessageDIV').html('<audio autoplay="autoplay"><source src="audio/10111.wav" type="audio/wav"/><source src="audio/10111.wav" type="audio/mpeg"/></audio>');
		}
	}
		
	
</script>
</head>
<body>
	<div id="newMessageDIV" style="display: none"></div>
</body>
</html>