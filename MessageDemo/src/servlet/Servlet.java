package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.OrderDaoImpl;
import entity.Order;

/**
 * 
 * @author zy
 *
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private OrderDaoImpl odi = new OrderDaoImpl();
	
    public Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if(method==null) {
			
		}else if("submit".equals(method)){
			//
			this.odi.save(new Order(1));//保持新订单，订单状态为1
			response.getWriter().write("true");
		}else if("listen".equals(method)){
			//
			int flag = 0;
			List<Order> olist = this.odi.findAll();
			for (Order order : olist) {
				if(order.getState()==1) {
					flag=1;break;
				}
			}
			if(flag==1) {
				response.getWriter().write("true");
			}else {
				response.getWriter().write("fault");
			}
		}else if("stop".equals(method)){
			//
			List<Order> olist = this.odi.findAll();
			for (Order order : olist) {
				order.setState(0);
				this.odi.update(order);
			}
			response.getWriter().write("true");
		}
	}

}
