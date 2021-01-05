package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.UpdateDao;

/**
 * Servlet implementation class DeleteRegisterProductServlet
 */
@WebServlet("/DeleteInventoryProductServlet")
public class DeleteInventoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInventoryProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		

		String productname = request.getParameter("productname");
		UpdateDao updateDao = new UpdateDao();
		
		if(updateDao.deleteInventoryProductDao(productname)) {
			//AdminQueryAllInventoryProductServlet.java 
			//this servlet is used to select all the inventory product to show for the admin
			request.getRequestDispatcher("AdminQueryAllInventoryProductServlet").forward(request, response);
			
		}else {
			response.getWriter().print("delete InventoryProduct failed");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
