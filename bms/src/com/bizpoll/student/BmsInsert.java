package com.bizpoll.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BmsDAO;
import com.bizpoll.dto.BmsDTO;

/**
 * Servlet implementation class BmsInsert
 */
@WebServlet("/BmsInsert")
public class BmsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmsInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO GET!");
		// insert.jsp로 페이지 이동
		response.sendRedirect("insert.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO POST!");
		request.setCharacterEncoding("UTF-8");
		// input태그 값을 받아와서 출력해보세요.
		// name값을 입력해야한다 (속성값x)
		int id = Integer.parseInt(request.getParameter("input_id"));
		String name = request.getParameter("input_name");
		int age = Integer.parseInt(request.getParameter("input_age"));
		String major = request.getParameter("input_major");
		int phone = Integer.parseInt(request.getParameter("input_phone"));
		
		System.out.println(id+", "+name+", "+age+", "+major+", "+phone);
		
		BmsDTO bDto = new BmsDTO(id, name, age, major, phone);
		BmsDAO bDao = new BmsDAO();
		int result = bDao.BmsInsert(bDto);	// 화면단에서 전송받은 값을 이동
		
		response.setContentType("text/html; charset=UTF-8"); // 한글깨짐 방식
		
		if(result > 0) {
			response.sendRedirect("index");
		} else {
			response.sendRedirect("BmsInsert"); // BmsInsert의 Servlet으로 이동
		}
		

/*		# 학생정보를 입력받아서 DB에서 저장
		1. 화면단에서 학생정보를 입력받는다.
		2. 화면단에서 받은 데이터를 Controller(Servlet)으로 이동
		3. Controller단에서 DAO 클래슬 이동
		4. SQL문 실행해서 DB에 저장
		5. 입력받은 학생정보를 Oracle DB에 저장한다.
		
		# 화면단에서 Controller단으로 이동
		
		
﻿  */
	
	}

}
