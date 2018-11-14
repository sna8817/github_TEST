package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.BmsDTO;


public class BmsDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<BmsDTO> list = new ArrayList<>();
	int result = 0;
	
	
	// insert
	public int BmsInsert(BmsDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO bstudent (id, name, age, major, phone) "
					+ "VALUES(?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bDto.getId());
			pstmt.setString(2, bDto.getName());
			pstmt.setInt(3, bDto.getAge());
			pstmt.setString(4, bDto.getMajor());
			pstmt.setInt(5, bDto.getPhone());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	// 학생 전체 조회
	public ArrayList<BmsDTO> selectBms(){
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM bstudent ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String major = rs.getString("major");
				int phone = rs.getInt("phone");
				BmsDTO bDto = new BmsDTO(id, name, age, major, phone);
				list.add(bDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	// 수정을 위한 회원정보 조회
	public ArrayList<BmsDTO> selectOne(String userid){
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM bstudent "
					+ "WHERE id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String major = rs.getString("major");
				int phone = rs.getInt("phone");
				BmsDTO bDto = new BmsDTO(id, name, age, major, phone);
				
				list.add(bDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	// update
	public int updateBms(BmsDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE bstudent SET "
				       + "name=?, "
				       + "age=?, "
				       + "major=?, "
				       + "phone=? "
					   + "WHERE id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getName());
			pstmt.setInt(2, bDto.getAge());
			pstmt.setString(3, bDto.getMajor());
			pstmt.setInt(4, bDto.getPhone());
			pstmt.setInt(5, bDto.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	
	public int deleteBms(int id) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM bstudent "
					   + "WHERE id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	
	
}
