package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author lixia
 */
public class ResetPasswordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String uuid = request.getParameter("uuid");

		if (uuid != null && ! uuid.trim().equals("")) {
			request.setAttribute("uuid", uuid);

			getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
			return;
		}
		
		getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		AccountService as = new AccountService();

		String uuid = request.getParameter("uuid");

		if (uuid == null) {

			String email = request.getParameter("email");
        		String path = getServletContext().getRealPath("/WEB-INF");
			String url = request.getRequestURL().toString();

			as.resetPassword(email, path, url);
			return;
		}

		String password = request.getParameter("password");
		as.changePassword(uuid, password);

	}
}
