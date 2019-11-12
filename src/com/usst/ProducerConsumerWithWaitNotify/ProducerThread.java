package com.usst.ProducerConsumerWithWaitNotify;

/**
 * 生产者线程
 */
public class ProducerThread extends Thread
{
    private Resource resource;

    public ProducerThread(Resource resource)
    {
        this.resource = resource;
    }

    public ProducerThread(String name, Resource resource)
    {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run()
    {
        //不断地生产资源
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                resource.add();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
