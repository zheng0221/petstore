package cn.petstore.service;
import java.util.List;
import java.sql.SQLException;
import java.util.Date;
import javax.security.auth.login.LoginException;

import cn.petstore.domain.Log;
import cn.petstore.domain.User;
import cn.petstore.dao.LogDao;
import cn.petstore.exception.ActiveUserException;
import cn.petstore.exception.ListProductException;
import cn.petstore.exception.RegisterException;
import cn.petstore.utils.MailUtils;

public class LogService {
	private LogDao dao = new LogDao();

	//查找所有日志
	public List<Log> listAll() throws ListProductException {
		try {
			return dao.listAll();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ListProductException("查询公告失败");
		}
	}

}
