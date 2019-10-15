package com.glqdlt.helper;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class FileEchoTest {
    @Test
    public void name() {
        String[] ext = {"java"};
        FileEcho fileEcho = new FileEcho(ext) {
            void info(String message) {
                System.out.println(message);
            }
        };
        fileEcho.print(ClassLoader.getSystemResource("").getPath());
    }

}