package cn.petstore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.petstore.utils.DataSourceUtils;

public class LoginDao {
	public void add(int uid,String name,String ipaddress) throws SQLException{
		String sql = "insert into login(uid,username,ipaddress) values(?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, uid,name,ipaddress);
		if (row == 0) {
			throw new RuntimeException();
		}
	}

}
