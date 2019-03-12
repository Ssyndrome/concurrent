package com.thoughtworks.concurrent.dojo.p7;

public class Synchronized {

    private static int count = 10;
    private Object o1 = new Object();
    private Object o2 = new Object();

    public void m1() {
        synchronized (o1) {
            count--;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1 end and count = " + count);
        }
    }

    public void m2() {
        synchronized (o2) {
            count--;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2 end and count = " + count);
        }
    }

    public static void main(String[] args) {
        Synchronized s = new Synchronized();
        new Thread(() -> s.m1()).start();
        new Thread(() -> s.m2()).start();
    }
}
