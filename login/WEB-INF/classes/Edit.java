import java.io.IOException;
import java.util.HashMap;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Edit extends HttpServlet {

    TemplateEngine t = new TemplateEngine();
    ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
    Context ct = new Context();

    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
         
        String name = req.getParameter("name");

        Store.key = name;

        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setSuffix(".html");
        
        ct.setVariable("choice", 3);
        ct.setVariable("key", 2);

        t.setTemplateResolver(resolver);
        t.process("temp", null, ct, res.getWriter());
        
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{

        String number = req.getParameter("number");

        Store.hp.put(Store.key,number);

        res.sendRedirect("/login/index.html");
    }
    
}
