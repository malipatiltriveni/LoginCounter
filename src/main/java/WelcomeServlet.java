import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int count = 0;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("loginCount".equals(c.getName())) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2 style='text-align:center;'>Welcome!</h2>");
        out.println("<h3 style='text-align:center;'>This is your " + count + "th login</h3>");
    }
}