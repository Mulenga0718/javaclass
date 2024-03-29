package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "LJG93";
	private static String password = "java";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	/*
	 * Map<String, Object> selectOne(String sql)  //조회결과가 한 줄일 때
	 * Map<String, Object> selectOne(String sql, List<Object> param)  //두번째 param은 ?가 들어갈 자리 
	 * List<Map<String, Object>> selectList(String sql) //조회결과가 여러줄일 경우에
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 * 
	 */	
	 
	public static List<Map<String, Object>> selectList(String sql, List<Object> param){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
		 con = DriverManager.getConnection(url, user, password);
		 
		 ps = con.prepareStatement(sql);
		 for(int i= 0; i< param.size(); i++) {
			 ps.setObject(i+1, param.get(i));
		 }
		 
		 rs = ps.executeQuery();
		 ResultSetMetaData metaData = rs.getMetaData();
		 int columnCount = metaData.getColumnCount();
		 
		 while(rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i=1; i<= columnCount; i++) {
				map.put(metaData.getColumnName(i), rs.getObject(i));
			}
			list.add(map);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		
		return list;
		}
	
	}
}