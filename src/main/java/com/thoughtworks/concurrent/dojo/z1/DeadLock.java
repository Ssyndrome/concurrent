package com.thoughtworks.concurrent.dojo.z1;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    private static Object a = new Object();
    private static Object b = new Object();

    private static void aToB() {
        synchronized (a) {
            System.out.println("a to b -- a start");
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (b) {
            System.out.println("a to b -- b start");
        }
    }

    private static void bToA() {
        synchronized (b) {
            System.out.println("b to a -- b start");
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (a) {
            System.out.println("b to a -- a start");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> aToB()).start();
        new Thread(() -> bToA()).start();
    }
}
