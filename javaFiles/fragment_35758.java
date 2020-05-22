package test.thread.load;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadLoadTest
{
    public static void main(final String[] args)
    {
        final ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        for (final long id : bean.getAllThreadIds())
        {
            System.out.println(bean.getThreadInfo(id).getThreadName()
                                  + ": " + bean.getThreadCpuTime(id));
        }
    }
}