import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Menu extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{

        TemplateEngine te = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setSuffix(".html");
        Context ct = new Context();
        
        String val = req.getParameter("button");
        ct.setVariable("c", val);
        switch (val) {
            case "Display":
            ct.setVariable("choice", 1);
            ct.setVariable("hp", Store.hp);
                break;
            case "Edit":
            ct.setVariable("choice", 2);
            ct.setVariable("key", 1);
                break;
            case "Create":
            ct.setVariable("choice", 4);
                break;
            case "Delete":
            ct.setVariable("choice", 3);
                break;
        }
        te.setTemplateResolver(resolver);
        te.process("temp", null, ct, res.getWriter());
        
    }
    
}
