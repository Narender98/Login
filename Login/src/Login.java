

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/Login")
public class Login extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Luid = request.getParameter("Luid");
		String Lpass = request.getParameter("Lpass");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "123456");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from logintest");
			
			String myUID = "", myPass = "",myUNAME = "";
			
			while(rs.next())
			{
				if(Luid.equalsIgnoreCase(rs.getString("USERID")) && Lpass.equals(rs.getString("Password")))
				{
					myUID = rs.getString("USERID");
					myPass = rs.getString("Password");
					myUNAME = rs.getString("USERNAME");
				}
			}
			
			if(Luid.equalsIgnoreCase(myUID) && Lpass.equals(myPass))
			{
				HttpSession session = request.getSession();
				session.setAttribute("Username", myUNAME);
				response.sendRedirect("Welcome.jsp");
			}
			else
			{
				request.setAttribute("errorMessageLogin", "Invalid UserID and Password");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
