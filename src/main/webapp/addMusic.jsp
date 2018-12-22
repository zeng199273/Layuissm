<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>carousel模块快速使用</title>
  <link rel="stylesheet" href="layui/css/layui.css">
  <script src="layui/layui.js"></script>
  <script src="js/jquery-2.1.1.js"></script> 
  <style>
  	.layui-input{
		width:200px;
	}
	h1,button{margin-left:130px;}
  </style>
  <script>
  	$(function(){
  		$("button").click(function(){
  			//取得表单的值
  			var musicName = $("input[name=musicName]").val(); 
  			var singerId = $("input[name=singerId]").val(); 
  			var musicURL = $("input[name=musicURL]").val(); 
  			var typeId = $("input[name=typeId]").val(); 
  			var photo = $("input[name=photo]").val(); 
  			//执行ajax请求
  			$.ajax({
  				url:'${pageContext.request.contextPath}/addMusic.action',
  				method:'POST',
  				data:{"musicName":musicName,"singerId":singerId,
  						"musicURL":musicURL,"typeId":typeId,"photo":photo},
  				dataType:'text',
  				success:function(data){
  					alert(data);
  				}
  			});
  		});
  	});
  </script>
</head>
<body>
<h1>添加数据</h1>
	<div class="layui-form-item">
    <label class="layui-form-label">音乐名称</label>
    <div class="layui-input-block">
      <input type="text" name="musicName" required  lay-verify="required" placeholder="请输入音乐名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">歌手ID</label>
    <div class="layui-input-block">
      <input type="text" name="singerId" required  lay-verify="required" placeholder="请输入歌手ID" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">歌曲地址</label>
    <div class="layui-input-block">
      <input type="text" name="musicURL" required  lay-verify="required" placeholder="请输入歌曲地址" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">类型ID</label>
    <div class="layui-input-block">
      <input type="text" name="typeId" required  lay-verify="required" placeholder="请输入类型ID" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">图片</label>
    <div class="layui-input-block">
      <input type="text" name="photo" required  lay-verify="required" placeholder="请输入图片" autocomplete="off" class="layui-input">
    </div>
  </div>
  <button class="layui-btn">确定添加</button>
</body>
</html>