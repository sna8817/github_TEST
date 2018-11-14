package com.bizpoll.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BigDAO;
import com.bizpoll.dto.BigDTO;

/**
 * Servlet implementation class BigdateTest
 */
@WebServlet("/BigdateTest")
public class BigdateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigdateTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		
		request.setCharacterEncoding("UTF-8");
		
		// 회원가입 insert
		String id = "user1001";
		String pw = "a123456789";
		String name = "김유저";
		String nick = "둥둥이";
		String addr = "광주북구 경양로 170번길 5층";
		String email = "user1001@gmail.com";
		String birth = "951003";
		String status = "Y";
		
		BigDTO bDto = new BigDTO(id, pw, name, nick, addr, email, birth, status);
		BigDAO bDao = new BigDAO();
		int result = bDao.BigInsert(bDto);
		
		response.setContentType("text/html; charset=UTF-8"); // 한글깨짐 방식
		
		if(result > 0) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패!");
		}
	}

}
