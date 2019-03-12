package com.thoughtworks.concurrent.dojo.p13;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Volatile {

    volatile int count = 0;

    synchronized void add () {
        for (int i = 0; i < 10000; i++) {
            count ++;
        }
    }

    public static void main(String[] args) {
        Volatile v = new Volatile();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(v::add, "thread-" + i));
        }

        threads.forEach(Thread::start);

/*
        threads.forEach(o -> {
            try {
                o.join();
                log.info("end thread {}", Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
*/

        log.info("count is {}", v.count);
    }
}
