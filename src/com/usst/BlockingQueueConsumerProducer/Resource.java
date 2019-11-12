package com.usst.BlockingQueueConsumerProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Resource
{
    //LinkedBlockingQueue是一个由链表结构组成的有界阻塞队列，在未指明容量时，容量默认为Integer.MAX_VALUE
    private BlockingQueue resourceQueue = new LinkedBlockingQueue(10);

    /**
     * 向资源池中添加资源
     */
    public void add()
    {
        try
        {
            resourceQueue.put(1);
            System.out.println("生产者" + Thread.currentThread().getName() + "生产一件资源," + "当前资源池有" + resourceQueue.size() + "个资源");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 向资源池中移除资源
     */
    public void remove()
    {
        try
        {
            resourceQueue.take();
            System.out.println("消费者" + Thread.currentThread().getName() + "消耗一件资源," + "当前资源池有" + resourceQueue.size() + "个资源");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
