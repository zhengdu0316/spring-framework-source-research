package org.vertex.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengdu
 * @date 2019/4/27
 */
public class ReentrantLockQuestion {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        synchronizeAction(ReentrantLockQuestion::action1);
    }

    private static void action1() {
        synchronizeAction(ReentrantLockQuestion::action2);
    }

    private static void action2() {
        synchronizeAction(ReentrantLockQuestion::action3);
    }

    private static void action3() {
        System.out.println("Hello,world");
    }

    private static void synchronizeAction(Runnable runnable){
        lock.lock();
        try{
            runnable.run();
        }finally {
            lock.unlock();
        }
    }
}
