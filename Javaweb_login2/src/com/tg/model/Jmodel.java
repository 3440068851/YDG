package com.tg.model;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hk.domain.User;
import com.jdbc.util.JdbcUtil2;



public class Jmodel {
	public User login(User user) throws SQLException{
		//�������ݿ⣬�������ݽ��в�ѯ
		QueryRunner queryrunner = new QueryRunner(JdbcUtil2.getDataSource());
		User existUser= queryrunner.query("select * from login where username = ? and password = ?", new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		
		return existUser;

}
}
