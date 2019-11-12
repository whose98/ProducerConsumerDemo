package com.usst.ProducerConsumerWithWaitNofity;

/**
 * 消费者线程
 */
public class ConsumerThread extends Thread
{
    private Resource resource;

    public ConsumerThread(Resource resource)
    {
        this.resource = resource;
    }

    public ConsumerThread(String name, Resource resource)
    {
        super(name);
        this.resource = resource;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                resource.remove();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
