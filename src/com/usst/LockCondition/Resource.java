package com.usst.LockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 公共资源类
 */
public class Resource
{
    private int num = 0;//当前资源数量
    private int size = 10;//资源池中允许存放的资源数目
    private Lock lock;
    private Condition producerCondition;
    private Condition consumerCondition;

    public Resource(Lock lock, Condition producerCondition, Condition consumerCondition)
    {
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    /**
     * 向资源池中添加资源
     */
    public void add()
    {
        lock.lock();
        try
        {
            if (num < size)
            {
                num++;
                System.out.println("生产者" + Thread.currentThread().getName() + "生产一件资源,当前资源池有" + num + "个");
                //唤醒等待的消费者
                consumerCondition.signalAll();
            }
            else
            {
                //已经生产满了,让生产者线程等待
                try
                {
                    System.out.println("资源满了,生产者" + Thread.currentThread().getName() + "线程进入等待");
                    producerCondition.await();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        } finally
        {
            lock.unlock();
        }
    }

    /**
     * 从资源池中取走资源
     */
    public void remove()
    {
        lock.lock();
        try
        {
            if (num > 0)
            {
                num--;
                System.out.println("消费者" + Thread.currentThread().getName() + "消耗一件资源," + "当前资源池有" + num + "个");
                producerCondition.signalAll();//唤醒等待的生产者
            }
            else
            {
                try
                {
                    //没资源了,等待生产者生产
                    System.out.println("没资源了,生产者" + Thread.currentThread().getName() + "线程进入等待");
                    consumerCondition.await();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }//让消费者等待
            }
        } finally
        {
            lock.unlock();
        }
    }
}
