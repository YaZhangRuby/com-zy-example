package com.zy.springboot.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangya
 * Date: 2019/5/17
 * Time: 16:32
 * Description:
 */
public class TestImpl {

    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            String[] array1 = {"a","e","i","o","u"};
            @Override
            public void run() {
                for (int i = 0; i < array1.length; i++) {
                    synchronized (object) {
                        object.notify();
                        System.out.print(array1[i]);
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                        object.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            String[] array2 = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    synchronized (object) {
                        System.out.print(array2[i]);
                        if (array2[i].equals("d") || array2[i].equals("h") || array2[i].equals("n") || array2[i].equals("t")) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.getStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
