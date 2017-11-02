package kr.co.saramin.emaillist.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.saramin.emaillist.vo.EmailListVo;

import java.sql.*;

public class EmailListDao {

	public List getList() {
		List<EmailListVo> list = new ArrayList<EmailListVo>();
		String url = "jdbc:mysql://localhost/webdb";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs   = null;
		
		try {
			//1. jdbs driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. connection 
			con		= DriverManager.getConnection(url,"webdb","webdb");
		
			//3. create stmt
			stmt	= con.createStatement();
			
			//4. excute sql
			String sql	= "SELECT * FROM emaillist";
			rs		= stmt.executeQuery(sql);
						
			//5. restore result
			while (rs.next()) {
				Long no 		= rs.getLong("no");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email    = rs.getString("email");
				
				EmailListVo evo = new EmailListVo();
				
				evo.setNo(no);
				evo.setFirstName(firstName);
				evo.setLastName(lastName);
				evo.setEmail(email);
				
				list.add(evo);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver loading fail.. ");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Driver connection fail.. " + e);
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				
				if ( stmt != null ) {
					stmt.close();
				}
				
				if ( con != null ) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public boolean insert(EmailListVo emailListVo)
	{
		
		String url = "jdbc:mysql://localhost/webdb";
		Connection con = null;
		PreparedStatement prstmt = null;
		
		int count = 0;
		
		try {
			//1. jdbs driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. connection 
			con		= DriverManager.getConnection(url,"webdb","webdb");
		
			String sql	= "INSERT INTO emaillist VALUES(null, ?,?,?)";

			//3. create stmt
			prstmt	= con.prepareStatement(sql);
			
			//4. binding
			prstmt.setString(1, emailListVo.getFirstName());
			prstmt.setString(2, emailListVo.getLastName());
			prstmt.setString(3, emailListVo.getEmail());
			
			//5. query excute
			count = prstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver loading fail.. ");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Driver connection fail.. " + e);
		} finally {
			try {
				
				if ( prstmt != null ) {
					prstmt.close();
				}
				
				if ( con != null ) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count < 1 ? false : true;
	}
	
}
