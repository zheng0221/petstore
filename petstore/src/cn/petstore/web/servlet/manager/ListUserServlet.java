package cn.petstore.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.petstore.domain.User;
import cn.petstore.exception.ListProductException;
import cn.petstore.service.UserService;

public class ListUserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// 1.创建service层的对象
		UserService service = new UserService();
		try {
			// 2.调用service层用于查询所有用户的方法
			List<User> ps = service.listAll();
			// 3.将查询出的所有用户放进request域中
			request.setAttribute("ps", ps);
			// 4.重定向到list.jsp页面
			request.getRequestDispatcher("/admin/user.jsp").forward(
					request, response);
			return;
		} catch (ListProductException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			return;
		}
	}

}
