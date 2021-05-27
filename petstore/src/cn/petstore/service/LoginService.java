package cn.petstore.service;

import java.sql.SQLException;
import java.util.Date;

import cn.petstore.dao.LoginDao;
import cn.petstore.exception.ActiveUserException;
import cn.petstore.exception.RegisterException;

public class LoginService {
	private LoginDao dao=new LoginDao();
	public void addLogin(int uid,String n,String ipaddress) throws SQLException {
		dao.add(uid,n,ipaddress);
	}

}
