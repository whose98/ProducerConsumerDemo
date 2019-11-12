package com.usst.LockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock 和 Condition解决生产者消费者问题
 */
public class LockCondition
{
    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        Resource resource = new Resource(lock, producerCondition, consumerCondition);

        //生产者线程
        ProducerThread producer1 = new ProducerThread(resource);
        ProducerThread producer2 = new ProducerThread(resource);
        ProducerThread producer3 = new ProducerThread(resource);

        //消费者线程
        ConsumerThread consumer1 = new ConsumerThread(resource);
        ConsumerThread consumer2 = new ConsumerThread(resource);
        ConsumerThread consumer3 = new ConsumerThread(resource);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}

