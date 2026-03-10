package com.yno.test;

import static com.yno.ConnectionManager.getConnectionWithStrings;
import static com.yno.test.UserDetail.getUserFromConsole;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class B_PrepareedStatementTest {
	
	
//	@Test
	void insertTest() {
		
		String sql = "insert into user_tbl(name, gender) values (?,?)";
		
		//create connection and statement
		try (var con = getConnectionWithStrings();
				var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		
		var user = getUserFromConsole();
		
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getGender().name());
//		stmt.setInt(2, user.getGender().ordinal()+1);
		
		
		/*
		 * Java Enum index MALE = 0
		 * 
		 * Database enum index MALE = 1
		 */
		
		int row = stmt.executeUpdate();
		
		var rs = stmt.getGeneratedKeys();
		
		while (rs.next()) {
			System.out.println(rs.getInt(1));
		}
		
		
		// if row = 1 , that is right
		assertEquals(1, row);		
			
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	
//	@Test
	void updateTest() {
		
		String sql = "update user_tbl set name = ? , gender= ? where id= ? ";
		
		try (var con = getConnectionWithStrings();
				var stmt = con.prepareStatement(sql)){
			
			var user = getUserFromConsole();
			
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getGender().name());
			stmt.setInt(3, user.getId());
			
			int row = stmt.executeUpdate();
			assertEquals(1, row);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test
	void deleteTest() {
		
		String sql = "Delete from user_tbl where id = ?";
		try (var con = getConnectionWithStrings();
			var stmt = con.prepareStatement(sql);){
			
			var user = getUserFromConsole();
			
			stmt.setInt(1, user.getId());
			
			int row = stmt.executeUpdate();
			assertEquals(1, row);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test
	void selectTest() {
		String sql = "select * from user_tbl";
		
		try (var con = getConnectionWithStrings();
				var stmt = con.prepareStatement(sql);){
			
			var rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("name")+ "\t");
				System.out.println(rs.getString("gender"));
			}
	
//			assertEquals(1, row);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void selectByProcedureTest() {
		String sql = "{call selectById(?)}";
		
		try (var con = getConnectionWithStrings();
				var stmt = con.prepareCall(sql);){
			
			stmt.setInt(1, 1);
			
			var rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.print("ID"+ rs.getString("id")+"\t");
				System.out.print("NAME " + rs.getString("name")+ "\t");
				System.out.println("GENDER" + rs.getString("gender"));
			}
	
//			assertEquals(1, row);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
