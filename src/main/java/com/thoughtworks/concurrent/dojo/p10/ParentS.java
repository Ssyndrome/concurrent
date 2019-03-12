package com.thoughtworks.concurrent.dojo.p10;

import java.util.concurrent.TimeUnit;

public class ParentS {
    public static synchronized void lock() {
        System.out.println("class" + " start lock");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("class" + " end lock");
    }

    public static void main(String[] args) {
        new KidS().lock();
    }
}

class KidS extends ParentS{
    public static void lock() {
        System.out.println("kid s start initialize");
        ParentS.lock();
        System.out.println("kid s end initialize");
    }
}