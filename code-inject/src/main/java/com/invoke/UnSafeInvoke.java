package com.invoke;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Controller
public class UnSafeInvoke {
    @RequestMapping("/invoke")
    @ResponseBody
    public void invoke(String content) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //com.invoke.Test
        Class c = Class.forName(content);
            if(c != null){
           c.newInstance();  ///
    }
}
    @RequestMapping("/invoke2")
    @ResponseBody
    public void invoke2(String command,String action,String classname) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //com.invoke.Test2
        Class c = Class.forName(classname);
        if(c != null){
            Method personmethod = c.getMethod(action,String.class);
            personmethod.invoke(c.newInstance(),command);
        }
    }
}
