ThreadMXBean mxbean = ManagementFactory.getThreadMXBean();

@Override
public int compare(Long threadId1, Long threadId2) {
    return Long.compare(mxbean.getThreadCpuTime(threadId2), mxbean.getThreadCpuTime(threadId1));
}