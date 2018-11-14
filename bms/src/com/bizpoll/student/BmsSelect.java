package com.bizpoll.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BmsDAO;
import com.bizpoll.dto.BmsDTO;

/**
 * Servlet implementation class BmsSelect
 */
@WebServlet("/BmsSelect")
public class BmsSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmsSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("select GET");
		
		// DB가서 학생 전체 리스트를 가져옴!
		BmsDAO bDao = new BmsDAO();
		
		ArrayList<BmsDTO> list = new ArrayList<>();
		list = bDao.selectBms();

		// Controller단에서 View단으로 데이터 전송
		// : list값을 select.jsp 화면단으로 전송
		
		// View단에서 Controller단으로 데이터 전송할때 보낼수 있는 방식 2가지
		// 1. GET
		// 2. POST
		
		// Controller단에서 페이지이동방법 2가지
		// 1. Redirect
		// 2. Forward
		
		
		// *Redirect방식
		// 데이터를 못 옮긴다. 이동밖에 못함
		// 쿼리스트링을 사용하여 get방식으로는 데이터 전달 가능
		// But POST방식으로 숨겨서 보낼 수는 없음
		// Spring에서는 flashArrtribute를 사용하면 POST로도 데이터전달가능
		// response.sendRedirect("select.jsp?add=");
		
		// 보낼데이터를 담는다.("이름표", 실제값)
		request.setAttribute("bmslist", list);
		
		// *Forward방식
		// Forward로 페이지이동
		RequestDispatcher dis = request.getRequestDispatcher("select.jsp");
		dis.forward(request, response);
		
		for (BmsDTO bmsDTO : list) {
			System.out.print(bmsDTO.getId()+"\t");
			System.out.print(bmsDTO.getName()+"\t");
			System.out.print(bmsDTO.getAge()+"\t");
			System.out.print(bmsDTO.getMajor()+"\t");
			System.out.print(bmsDTO.getPhone()+"\t");
			System.out.println();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("select POST");
	}

}
