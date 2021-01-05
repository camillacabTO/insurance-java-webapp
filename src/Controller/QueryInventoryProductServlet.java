package Controller;
/*
 * 
 * For drop down list...............................
 * 
 * */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.QueryDao;
import Entity.Product;

/**
 * Servlet implementation class QueryInventoryProductServlet
 */
@WebServlet("/QueryInventoryProductServlet")
public class QueryInventoryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryInventoryProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		QueryDao queryDao = new QueryDao();
		List<Product>  InventoryProducts = queryDao.queryInventoryProduct();
		
		request.setAttribute("InventoryProducts", InventoryProducts);
//		request.getRequestDispatcher("queryInventoryProducts.jsp").forward(request, response);
		request.getRequestDispatcher("product_registeration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
