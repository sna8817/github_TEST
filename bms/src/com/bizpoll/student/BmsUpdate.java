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
 * Servlet implementation class BmsUpdate
 */
@WebServlet("/BmsUpdate")
public class BmsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmsUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update get");
		
		String id = request.getParameter("userid");
		System.out.println("======>id: "+id);

		// id값으로 회원정보를 조회
		BmsDAO bDao = new BmsDAO();
		ArrayList<BmsDTO> list = new ArrayList<>();
		list = bDao.selectOne(id);
		
		// 보낼 데이터를 담는다.("이름표", 실제값);
		request.setAttribute("onelist", list);
		
		// *Forward방식
		// Forward로 페이지이동
		RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
		dis.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update post");
		
		// 수정버튼 클릭시 데이터 가져와서 출력하는 코드 작성
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
		int result = bDao.updateBms(bDto);	// 화면단에서 전송받은 값을 이동
		
		response.setContentType("text/html; charset=UTF-8"); // 한글깨짐 방식
		
		if(result > 0) {
			response.sendRedirect("BmsSelect");
		} else {
			response.sendRedirect("BmsUpdate?userid="+id);
		}
		
	}

}