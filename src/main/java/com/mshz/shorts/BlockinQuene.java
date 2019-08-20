package com.mshz.shorts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/20 14:33
 * @Version: 1.0
 */

public class BlockinQuene {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        take(queue);
        take(queue);
        put(queue);
    }

    public static void take(LinkedBlockingQueue<String> queue) {
        new Thread(() -> {
            String take = null;
            try {
                take = queue.take();
                System.out.println(take + ":属性");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.offer("aa");
            System.out.println(take);
        }).start();
    }

    public static void put(LinkedBlockingQueue<String> queue) {
        queue.offer("咋说的啊");
    }
}
