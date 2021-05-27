package cn.petstore.web.servlet.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.petstore.domain.Order;
import cn.petstore.domain.OrderItem;
import cn.petstore.domain.User;
import cn.petstore.dao.OrderItemDao;
import cn.petstore.service.OrderService;
import cn.petstore.service.UserService;

public class FindUserContentByIdServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String id = request.getParameter("id");
		UserService service1=new UserService();
		
		
		User user;
		try {
			user = service1.findUserById(id);
			request.setAttribute("user", user);
			// 调用service中的方法,根据用户信息查找订单
			OrderService service = new OrderService();
			List<Order> orders = service.findOrderByUser(user);
			double sum=0.0d;
			String status="";
			int dog=0;
			int cat=0;
			int mouse=0;
			int panda=0;
			for(int i=0;i<orders.size();i++) {
				sum+=orders.get(i).getMoney();
				OrderItemDao oidao=new OrderItemDao();
				List<OrderItem> orderItems=oidao.findOrderItemByOrder(orders.get(i));
				
				for(int j=0;j<orderItems.size();j++) {
					String cate=orderItems.get(j).getP().getCategory();
					
					int num=orderItems.get(j).getBuynum();
					
					if(cate.equals("dog")) {
						dog+=num;
					}else if(cate.equals("cat")) {
						cat+=num;
					}else if(cate.equals("mouse")) {
						mouse+=num;
					}else {
						panda+=num;
					}
				}
			}
			String like="";
			if(dog>cat&&dog>mouse&&dog>panda) {
				like="活力旺旺";
			}else if(cat>dog&&cat>mouse&&cat>panda) {
				like="优雅喵喵";
			}else if(mouse>cat&&mouse>dog&&mouse>panda) {
				like="口袋怪兽";
			}else if(panda>dog&&panda>cat&&panda>mouse) {
				like="掌上明珠";
			}else {
				like="用户暂无特别喜好";
			}
			if(sum==0.0) {
				status="潜在客户";
			}else if(sum>200.0) {
				status="VIP客户";
			}else {
				status="正常客户";
			}
			request.setAttribute("sum", sum);
			request.setAttribute("dog", dog);
			request.setAttribute("cat", cat);
			request.setAttribute("mouse", mouse);
			request.setAttribute("panda", panda);
			request.setAttribute("like", like);
			request.setAttribute("status", status);
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("/admin/userpic.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
