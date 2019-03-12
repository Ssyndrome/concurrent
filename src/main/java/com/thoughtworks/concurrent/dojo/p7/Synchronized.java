package com.thoughtworks.concurrent.dojo.p7;

/*
*
*  synchronized 的三种应用方式，他们的作用范围、获取了什么对象的锁
*
*
* */

public class Synchronized {

    private static int count = 10;
    private Object o1 = new Object();
    private Object o2 = new Object();

    public synchronized void m1() {
        count--;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 end and count = " + count);
    }

    public synchronized void m2() {
        count--;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end and count = " + count);
    }

    public static void main(String[] args) {
        Synchronized s1 = new Synchronized();
        Synchronized s2 = new Synchronized();
        new Thread(() -> s1.m1()).start();
        new Thread(() -> s2.m2()).start();
    }
}
