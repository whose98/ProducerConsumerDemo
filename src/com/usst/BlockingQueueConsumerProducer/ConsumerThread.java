package com.usst.BlockingQueueConsumerProducer;

/**
 * 消费者线程
 */
public class ConsumerThread extends Thread
{
    private Resource resource;

    public ConsumerThread(Resource resource)
    {
        this.resource = resource;
        //setName("消费者");
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep((long) (1000 * Math.random()));
                resource.remove();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
