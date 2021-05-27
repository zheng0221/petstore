package cn.petstore.dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.petstore.domain.Denglu;
import cn.petstore.utils.DataSourceUtils;

public class DengluDao {

	//查找所有日志
	public List<Denglu> listAll() throws SQLException {
		String sql = "select * from login";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Denglu>(Denglu.class));
	}


}
