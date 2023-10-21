import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Create extends HttpServlet {
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{

        String name = req.getParameter("name");
        String number = req.getParameter("number");

        Store.hp.put(name,number);
        res.getWriter().println(name);
        res.getWriter().println(number);

        // res.sendRedirect("/login/index.html");

    }

}
 