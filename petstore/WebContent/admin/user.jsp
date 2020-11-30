<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/admin/css/Style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<title>用户管理</title>

</head>
<body>

<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/ListUser"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>用 户 列 表</strong>
					</TD>
				</tr>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="8%">用户编号</td>
								<td align="center" width="8%">用户名称</td>
								<td align="center" width="8%">用户性别</td>
								<td align="center" width="15%">用户邮件</td>
								<td width="15%" align="center">用户电话</td>
								<td width="16%" align="center">用户画像查看</td>
								
							</tr>
                            <!--  循环输出所有用户 -->
							<c:forEach items="${ps}" var="p">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${p.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${p.username }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.gender }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.email }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${p.telephone}</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
									    <a href="${pageContext.request.contextPath}/findUserContentById?id=${p.id}">
											<img src="${pageContext.request.contextPath}/admin/images/i_edit.gif" border="0" style="CURSOR: hand"> 
										</a>
									</td>
									
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>

</body>
</html>