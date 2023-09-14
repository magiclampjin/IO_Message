package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import dto.ContactDTO;

@WebServlet("*.contacts")
public class ContactController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getRequestURI();
		ContactDAO dao = ContactDAO.getInstance();
		
		try {
			if(cmd.equals("/insert.contacts")) {
				String writer = request.getParameter("name");
				String contact = request.getParameter("contact");
				dao.insertContact(writer, contact);
				response.sendRedirect("index.jsp");
			}else if(cmd.equals("/listing.contacts")) {
				List<ContactDTO> list = new ArrayList<>();
				list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("/output_form.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
