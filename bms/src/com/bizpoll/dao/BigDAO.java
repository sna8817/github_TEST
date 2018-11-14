package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.BigDTO;

public class BigDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<BigDTO> list = new ArrayList<>();
	int result = 0;
	
	
	// insert
	public int BigInsert(BigDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO member2 (id, pw, name, nick, addr, email, birth, status) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, bDto.getId());;
			pstmt.setString(2, bDto.getPw());;
			pstmt.setString(3, bDto.getName());;
			pstmt.setString(4, bDto.getNick());;
			pstmt.setString(5, bDto.getAddr());;
			pstmt.setString(6, bDto.getEmail());;
			pstmt.setString(7, bDto.getBirth());;
			pstmt.setString(8, bDto.getStatus());;
				
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	// id 조회
	public String selectID(String loginid){
		String ckid="";
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM member2 "
					+ "WHERE id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ckid = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return ckid;
	}
	
	
	// pw 조회
	public String selectPW(String loginpw) {
		String ckpw="";
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM member2 "
					+ "WHERE pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginpw);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ckpw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return ckpw;
	}
	
}
