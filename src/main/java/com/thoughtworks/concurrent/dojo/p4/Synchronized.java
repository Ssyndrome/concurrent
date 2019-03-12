package com.thoughtworks.concurrent.dojo.p4;

public class Synchronized {

    private static int count = 10;

    public synchronized static void m() {
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized (Synchronized.class) {
            count --;
        }
    }
}
