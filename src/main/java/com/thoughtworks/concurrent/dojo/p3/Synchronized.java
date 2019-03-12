package com.thoughtworks.concurrent.dojo.p3;

public class Synchronized {

    private int count = 10;

    public synchronized void m() {
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
