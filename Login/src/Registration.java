

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Registration extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String Ruid = request.getParameter("Ruid");
		String Runame = request.getParameter("Runame");
		String Rpass1 = request.getParameter("Rpass1");
		String Rpass2 = request.getParameter("Rpass2");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" , "root" , "123456");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from logintest");
			
			String myUID = "", myPass = "";
			
			while(rs.next())
			{
				if(Ruid.equals(rs.getString("USERID")))
				{
					myUID = Ruid;
				}
			}
			
			if(Ruid.equals(myUID))
			{
				request.setAttribute("errorMessageRegister", "UserID Alredy Registered");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else if(Rpass1.length()<5 || Rpass2.length()<5)
			{
				request.setAttribute("errorMessageRegister", "Password length must be 5 digit");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else if(!Rpass1.equals(Rpass2))
			{
				request.setAttribute("errorMessageRegister", "Password Not Matched");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("insert into logintest(USERID,USERNAME,PASSWORD)values('"+Ruid+"','"+Runame+"','"+Rpass1+"')");
				ps.execute();
				response.sendRedirect("RegisterMessage.jsp");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}