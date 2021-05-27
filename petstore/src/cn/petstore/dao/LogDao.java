package cn.petstore.dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.petstore.domain.Product;
import cn.petstore.domain.Log;
import cn.petstore.utils.DataSourceUtils;

public class LogDao {

	//查找所有日志
	public List<Log> listAll() throws SQLException {
		String sql = "select * from log";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Log>(Log.class));
	}


}
