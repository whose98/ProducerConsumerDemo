package com.usst.ProducerConsumerWithWaitNotify;

/**
 * 公共资源类
 */
public class Resource
{
    //当前资源数量
    private int num = 0;
    //资源池中允许存放的资源数目
    private int size = 10;

    /**
     * 从资源池中取走资源
     */
    public synchronized void remove()
    {
        if (num > 0)
        {
            num--;
            System.out.println(Thread.currentThread().getName() + "消耗一件资源，" + "当前线程池有" + num + "个");
            notifyAll();//通知生产者生产资源
        }
        else
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + "线程进入等待状态");
                wait();//如果没有资源，则消费者进入等待状态
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向资源池中添加资源
     */
    public synchronized void add()
    {
        if (num < size)
        {
            num++;
            System.out.println(Thread.currentThread().getName() + "生产一件资源，当前资源池有" + num + "个");
            notifyAll();//通知等待的消费者
        }
        else
        {
            //如果当前资源池中有10件资源
            try
            {
                System.out.println(Thread.currentThread().getName() + "线程进入等待");
                wait();//生产者进入等待状态，并释放锁
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
