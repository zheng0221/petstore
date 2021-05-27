package cn.petstore.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.petstore.utils.PaymentUtil;
/**
 * 付款（模拟支付）
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.将要提交的数据得到
		// 获得 支付必须基本数据
		/*String ordernum=request.getParameter("ordernum");

        String money=request.getParameter("money");

        String pd_FrpId=request.getParameter("pd_FrpId");

         

         

         

        String p0_Cmd = "Buy";

        String p1_MerId = "10001126856";

        String p2_Order = ordernum;

        String p3_Amt = money;

        String p4_Cur = "CNY";

        String p5_Pid = "books";  //商品名称

        String p6_Pcat = "unknown";

        String p7_Pdesc = "descrition";

        String p8_Url = "http://localhost:8080"+request.getContextPath()+"/servlet/ResponsePayServlet";

        String p9_SAF = "1";

        String pa_MP = "unknown";

        String pr_NeedResponse="1";

        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");

         

        request.setAttribute("p0_Cmd",p0_Cmd );

        request.setAttribute("p1_MerId",p1_MerId );

        request.setAttribute("p2_Order", p2_Order);

        request.setAttribute("p3_Amt", p3_Amt);

        request.setAttribute("p4_Cur",p4_Cur );

        request.setAttribute("p5_Pid",p5_Pid );

        request.setAttribute("p6_Pcat",p6_Pcat );

        request.setAttribute("p7_Pdesc",p7_Pdesc );

        request.setAttribute("p8_Url",p8_Url );

        request.setAttribute("pa_MP",pa_MP );

        request.setAttribute("pr_NeedResponse",pr_NeedResponse );

        request.setAttribute("hmac",hmac );

        request.setAttribute("p9_SAF",p9_SAF );

        request.setAttribute("pd_FrpId", pd_FrpId);

         

        request.getRequestDispatcher("/sure.jsp").forward(request, response);
*/
		String orderid = request.getParameter("orderid");
		String money = request.getParameter("money");
		// 银行
		String bank = request.getParameter("yh");		
		request.setAttribute("bank", bank);
		request.setAttribute("orderid", orderid);	
		request.setAttribute("money", money);
		request.getRequestDispatcher("/client/confirm.jsp").forward(request, response);
	}
}
