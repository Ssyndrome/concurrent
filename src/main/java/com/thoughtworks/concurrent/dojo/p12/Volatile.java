package com.thoughtworks.concurrent.dojo.p12;

import lombok.extern.java.Log;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Log
public class Volatile {

    private boolean isRunning = true;

    void run() {
        System.out.println("start running.");

        while (isRunning) {
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            log.info(new Date().toString());
        }
        System.out.println("end running!");
    }

    void stopRunning() {
        this.isRunning = false;
    }

    public static void main(String[] args) {
        Volatile v = new Volatile();
        new Thread(v::run).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        v.stopRunning();
    }
}
