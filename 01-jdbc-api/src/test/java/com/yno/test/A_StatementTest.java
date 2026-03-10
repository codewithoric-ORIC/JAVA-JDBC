package com.yno.test;

import static com.yno.ConnectionManager.getConnectionWithStrings;
import static com.yno.test.UserDetail.getUserFromConsole;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class A_StatementTest {
	
	
//	@Test
	void insertTest() {
		
		try (var con = getConnectionWithStrings();
				var stmt = con.createStatement()) {
			
		var user = getUserFromConsole();	
		String sql = "insert into user_tbl(name, gender) values ('%s', '%s')"
				.formatted(user.getName(), user.getGender());
		int row = stmt.executeUpdate(sql);
		
		// if row = 1 , that is right
		assertEquals(1, row);		
			
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	
//	@Test
	void updateTest() {
		
		try (var con = getConnectionWithStrings();
				var stmt = con.createStatement()) {
			
			var user = getUserFromConsole();
			
			String sql = "update user_tbl set name = '%s' , gender='%s' where id=%d "
					.formatted(user.getName(), user.getGender(),1);
			
			int row = stmt.executeUpdate(sql);
			
			// if row = 1 , that is right
			assertEquals(1, row);
			
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	
//	@Test
//	void deleteTest() {
//		
//		try (var con = getConnectionWithStrings();
//				var stmt = con.createStatement()) {
////			var rs = stmt.close();
//		} catch (Exception e) {
//			e.printStackTrace();		
//		}
//
//	}
	
	@Test
	void selectTest() {
		
		try (var con = getConnectionWithStrings();
				var stmt = con.createStatement()) {
			
			String sql = "Select * from user_tbl";
			var rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print(rs.getString("name")+ "\t");
				System.out.println(rs.getString("gender"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	
//	@Test
	void bathUpdateTest() {
		
		try (var con = getConnectionWithStrings();
				var stmt = con.createStatement()) {
			
			stmt.addBatch("insert into user_tbl (name, gender) values ('Ye Naing',1)");
			stmt.addBatch("insert into user_tbl (name, gender) values ('Hla Hla',2)");
			
			stmt.executeBatch();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	
}
