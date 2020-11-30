<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户画像</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
body{background:#fff;color:#333;font-family:"Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;font-size:0.9em;}
#container{width:900px;margin:50px auto;}
#chart, #chartData{border:1px solid #333;background:#ebedf2 url("images/gradient.png") repeat-x 0 0;}
#chart{display:block;margin:0 0 50px 0;float:left;cursor:pointer;}
#chartData{width:200px;margin:20px 40px 0 0;float:right;border-collapse:collapse;box-shadow:0 0 1em rgba(0, 0, 0, 0.5);-moz-box-shadow:0 0 1em rgba(0, 0, 0, 0.5);-webkit-box-shadow:0 0 1em rgba(0, 0, 0, 0.5);background-position:0 -100px;}
#chartData th, #chartData td{padding:0.5em;border:1px dotted #666;text-align:left;}
#chartData th{border-bottom:2px solid #333;text-transform:uppercase;}
#chartData td{cursor:pointer;}
#chartData td.highlight{background:#e8e8e8;}
#chartData tr:hover td{background:#f0f0f0;}

#table1{width:400px;margin:20px 0 0 20px;float:left;border-collapse:collapse;box-shadow:0 0 1em rgba(0, 0, 0, 0.5);-moz-box-shadow:0 0 1em rgba(0, 0, 0, 0.5);-webkit-box-shadow:0 0 1em rgba(0, 0, 0, 0.5);background-position:0 -100px;}
#table1 th, #table1 td{padding:0.5em;border:1px dotted #666;text-align:left;}
#table1 th{border-bottom:2px solid #333;text-transform:uppercase;}
#table1 td{cursor:pointer;}
#table1 td.highlight{background:#e8e8e8;}
#table1 tr:hover td{background:#f0f0f0;}

</style>

<script src="js/jquery.min.js"></script>
<!--[if IE]>
<script src="js/excanvas.js"></script>
<![endif]-->

<script type="text/javascript" src="js/pieChart.js"></script>

<table width="50%" border="0" cellspacing="0" id="table1">

<tr><td>用户编号</td><td>${user.id}</td></tr>
<tr><td>用户名称</td><td>${user.username}</td></tr>
<tr><td>用户性别</td><td>${user.gender}</td></tr>
<tr><td>用户邮件</td><td>${user.email}</td></tr>
<tr><td>用户电话</td><td>${user.telephone}</td></tr>
<tr><td>用户消费总额</td><td>${sum}</td></tr>
<tr><td>用户身份</td><td>${status}</td></tr>
<tr><td>用户喜好</td><td>${like}</td></tr>
</table>

<table id="chartData">
<tr><td><a href="${pageContext.request.contextPath}/admin/pie.jsp?red=${red}&yellow=${yellow}&blue=${blue}&white=${white}">查看用户购买趋势</a></td></tr>
			<tr>
				<th>种类</th><th>购买量</th>
			</tr>
			<tr style="color:#ED5713">
				<td>草本花卉</td><td>${red}</td>
			</tr>
			<tr style="color:#ED9C13">
				<td>乔木花卉</td><td>${yellow}</td>
			</tr>
			<tr style="color:#194E9C">
				<td>灌木花卉</td><td>${blue}</td>
			</tr>
			<tr style="color:#0DA068">
				<td>藤本花卉</td><td>${white}</td>
			</tr>
			
			
		</table>

<table cellspacing="0" class="infocontent">
						<tr>
							<td style="padding:20px"><p><b>用户订单</b></p>
								<p>
									共有<font style="color:#FF0000" >${orders.size()}</font>订单
								</p>
								<table width="100%" border="0" cellspacing="0" class="tableopen">
									<tr>
										<td bgcolor="#A3E6DF" class="tableopentd01">订单编号</td>
										<td bgcolor="#A3D7E6" class="tableopentd01">订单金额</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">订单时间</td>
										<td bgcolor="#A3B6E6" class="tableopentd01">状态</td>
										<td bgcolor="#A3E2E6" class="tableopentd01">操作</td>
									</tr>
									<c:forEach items="${orders}" var="order">
										<tr>
											<td class="tableopentd02">${order.id}</td>
											<td class="tableopentd02">${order.money}</td>
											<td class="tableopentd02">${order.ordertime}</td>
											<td class="tableopentd02">${order.paystate==0?"未支付":"已支付"}</td>
											<td class="tableopentd03">
												<a href="${pageContext.request.contextPath}/findOrderById?id=${order.id}">查看</a>&nbsp;&nbsp;
												
											</td>
										</tr>
									</c:forEach>
									
								</table>
							</td>
						</tr>
					</table>
					
					
</body>
</html>