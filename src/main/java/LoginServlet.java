import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {

            int count = 0;

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("loginCount".equals(c.getName())) {
                        count = Integer.parseInt(c.getValue());
                    }
                }
            }

            count++;

            Cookie cookie = new Cookie("loginCount", String.valueOf(count));
            cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
            response.addCookie(cookie);

            response.sendRedirect(request.getContextPath() + "/WelcomeServlet");

        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp?error=1");
        }
    }
}