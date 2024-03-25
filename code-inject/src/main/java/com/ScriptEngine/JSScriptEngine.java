package com.ScriptEngine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.*;

@Controller
public class JSScriptEngine {
    @RequestMapping("/jscmd1") ///直接传入
    @ResponseBody
    public void jscmd1(String content) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        engine.eval(content);
    }

    @RequestMapping("/jscmd2")   //url加载js   需要启动javascript引擎
    @ResponseBody
    public void jscmd2(String content) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);//启动javascript引擎
        String cmd = String.format("load(\"%s\")", content);
        engine.eval(cmd,bindings);
    }

    @RequestMapping("/jscmd3")  ///compiledScript.eval
    @ResponseBody
    public void jscmd3(String content) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        CompiledScript compiledScript = ((Compilable)engine).compile(content);
        Bindings bindings = engine.createBindings();
        Object result = compiledScript.eval(bindings);
    }
}

