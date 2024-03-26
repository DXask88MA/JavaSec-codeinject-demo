package com.invoke;

import java.io.IOException;

public class Test2 {
    public void test(String commamd){
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
