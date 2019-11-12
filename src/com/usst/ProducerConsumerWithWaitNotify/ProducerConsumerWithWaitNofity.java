package com.usst.ProducerConsumerWithWaitNotify;

public class ProducerConsumerWithWaitNofity
{
    public static void main(String[] args)
    {
        Resource resource = new Resource();
        //生产者线程
        ProducerThread p1 = new ProducerThread("生产者1", resource);
        ProducerThread p2 = new ProducerThread("生产者2", resource);
        ProducerThread p3 = new ProducerThread("生产者3", resource);
        //消费者线程
        ConsumerThread c1 = new ConsumerThread("消费者1", resource);
        ConsumerThread c2 = new ConsumerThread("消费者2", resource);
        ConsumerThread c3 = new ConsumerThread("消费者3", resource);

        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();
    }
}