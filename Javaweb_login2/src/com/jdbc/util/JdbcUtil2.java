package com.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil2 {
private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	
	/**
	 * 获得连接对象
	 * @throws SQLException 
	 */
	
	public static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}
	
	
	/**
	 * 获得连接池
	 */
	public static DataSource getDataSource(){
		return datasource;
	}
	/**
	 * 释放资源
	 */
	public static void release(Statement sta,ResultSet rs,Connection con){
		if(sta != null){
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sta=null;
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=null;
		}
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
	}
}
