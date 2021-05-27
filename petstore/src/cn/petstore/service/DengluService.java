package cn.petstore.service;
import java.util.List;
import java.sql.SQLException;
import java.util.Date;
import javax.security.auth.login.LoginException;


import cn.petstore.dao.DengluDao;
import cn.petstore.domain.Denglu;
import cn.petstore.exception.ActiveUserException;
import cn.petstore.exception.ListProductException;
import cn.petstore.exception.RegisterException;
import cn.petstore.utils.MailUtils;

public class DengluService {
	private DengluDao dao = new DengluDao();

	//查找所有日志
	public List<Denglu> listAll() throws ListProductException {
		try {
			return dao.listAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ListProductException("查询登录记录失败");
		}
	}

}
