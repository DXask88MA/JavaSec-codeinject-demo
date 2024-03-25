package com.Groovy;

import groovy.lang.GroovyClassLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GroovyClassLoaderController {
    //groovy提供了一种将字符串文本代码直接转换成Java Class对象的功能
    @RequestMapping("/GroovyClassLoader")
    @ResponseBody
    public void groovyClassLoader(@RequestParam String groovy) throws InstantiationException, IllegalAccessException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class<?> clazz = groovyClassLoader.parseClass(groovy);
        clazz.newInstance();
    }


}
