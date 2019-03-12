package com.thoughtworks.concurrent.dojo.p8;

/*
*
* 对业务写方法加锁 对读方法不加锁 容易出现脏读问题
*
* */

import java.util.concurrent.TimeUnit;

public class Account {

    private String name;
    private String mobile;
    private double balance;

    public synchronized void setAccount(String name, String mobile, double balance) {
        this.name = name;
        this.mobile = mobile;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Account lily = new Account();
        new Thread(() -> lily.setAccount("lily", "110", 100)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lily has " + lily.getBalance());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lily has " + lily.getBalance());
    }
}
