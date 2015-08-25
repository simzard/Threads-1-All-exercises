package ex4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TurnstileCounter {

    private final Lock lock = new ReentrantLock();

    static final long DELAY_VAL = 10000;
    long count = 0;

    public long getValue() {
        return count;
    }

    public void incr() {
//   If the program initially does not fail, replace the count line with the lines below
//    long n = count;
//    //Spend some time to force preemtion
//    for(long a=0; a<LockDemo.DELAY_VAL; a++);
//    n = n + 1;
//    count = n;

        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
