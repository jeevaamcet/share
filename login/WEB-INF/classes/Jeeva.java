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

public class Jeeva extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
         
        // String name = req.getParameter("name");
        String val = req.getParameter("button");

        TemplateEngine t = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();

        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        // resolver.setPrefix("./../WEB-INF/templates/");
        resolver.setSuffix(".html");
        HashMap<String,String> hp = new HashMap<>();
        hp.put("jeeva","7963214698");
        hp.put("gokul","8697412369");
        hp.put("rahul","7418529636");
        hp.put("sandy","9638527414");
        Context ct = new Context();
        ct.setVariable("hp", hp);
        ct.setVariable("choice", 3);
        ct.setVariable("c", val);

        t.setTemplateResolver(resolver);
        t.process("temp", null, ct, res.getWriter());
        
    }
}
