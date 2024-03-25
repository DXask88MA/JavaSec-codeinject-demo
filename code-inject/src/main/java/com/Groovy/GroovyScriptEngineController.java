package com.Groovy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Controller
public class GroovyScriptEngineController {
    @RequestMapping("/GroovyScriptEngine")
    @ResponseBody
    public void groovyshell(String content) throws ScriptException {
        ///ScriptEngine解析器
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        engine.eval(content);
    }
}
