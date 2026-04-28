import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String college = request.getParameter("college");
        String eventname = request.getParameter("eventname");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Connection con = DBConnection.getConnection();

            String query = "insert into registrations(id,fullname,email,phone,college,eventname) values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, fullname);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, college);
            ps.setString(6, eventname);

            int i = ps.executeUpdate();

            if(i > 0) {
                out.println("<h1 style='color:green;text-align:center;'>Registration Successful!</h1>");
                out.println("<center><a href='index.html'>Go Home</a></center>");
            }
            else {
                out.println("Registration Failed");
            }

        } catch(Exception e) {
            out.println(e);
        }
    }
}