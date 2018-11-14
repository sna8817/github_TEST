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
 * Servlet implementation class BmsDelete
 */
@WebServlet("/BmsDelete")
public class BmsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("delete get");
		
		int id = Integer.parseInt(request.getParameter("userid"));
		System.out.println("======>id: "+id);

		BmsDAO bDao = new BmsDAO();
		int result = bDao.deleteBms(id);
		
		if(result>0) {
			response.sendRedirect("BmsSelect");
		} else {
			response.sendRedirect("BmsDelete=?userid="+id);
		}
		

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete post");
	}

}
