package com.thoughtworks.concurrent;

import com.thoughtworks.concurrent.dojo.p3.Synchronized;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcurrentApplication {

    public static void main(String[] args) {
        m();
        SpringApplication.run(ConcurrentApplication.class, args);
    }

    private static void m() {
        Synchronized s = new Synchronized();
        s.m();
        s.m();
        s.m();
    }


}
