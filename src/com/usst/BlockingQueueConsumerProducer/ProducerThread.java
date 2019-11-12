package com.usst.BlockingQueueConsumerProducer;

/**
 * 生产者线程
 */
public class ProducerThread extends Thread
{
    private Resource resource;

    public ProducerThread(Resource resource)
    {
        this.resource = resource;
        //setName("生产者");
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep((long) (1000 * Math.random()));
                resource.add();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
