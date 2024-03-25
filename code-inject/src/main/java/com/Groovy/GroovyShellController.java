package com.Groovy;

import groovy.lang.GroovyShell;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GroovyShellController {
    @RequestMapping("/GroovyShell")
    @ResponseBody
    public void groovyshell(String content) {
        //GroovyShell可动态运行groovy语言
        GroovyShell groovyShell = new GroovyShell();
        groovyShell.evaluate(content);
    }

}
