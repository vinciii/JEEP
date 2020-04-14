package com.jee.prac.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static ComboPooledDataSource getDataS() {
			
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		
		return dataSource.getConnection();
	}

}
