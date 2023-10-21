import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{

        String name = req.getParameter("name");

        Store.hp.remove(name);

        res.sendRedirect("/login/index.html");
    }
    
}
