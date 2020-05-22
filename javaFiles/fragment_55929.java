public RingBuffer<T> start()
{
    EventProcessor[] gatingProcessors = eventProcessorRepository.getLastEventProcessorsInChain();
    ringBuffer.setGatingSequences(Util.getSequencesFor(gatingProcessors));

    checkOnlyStartedOnce();
    for (EventProcessorInfo<T> eventProcessorInfo : eventProcessorRepository)
    {
        executor.execute(eventProcessorInfo.getEventProcessor());
    }

    return ringBuffer;
}