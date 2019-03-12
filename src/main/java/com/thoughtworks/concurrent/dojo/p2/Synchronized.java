package com.thoughtworks.concurrent.dojo.p2;

public class Synchronized {

    private int count = 10;

    public void m() {
        synchronized (this) { //锁定的是一个对象
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
