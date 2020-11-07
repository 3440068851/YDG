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
	 * ������Ӷ���
	 * @throws SQLException 
	 */
	
	public static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}
	
	
	/**
	 * ������ӳ�
	 */
	public static DataSource getDataSource(){
		return datasource;
	}
	/**
	 * �ͷ���Դ
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
