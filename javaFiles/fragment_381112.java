ReactorProcessor<Message, Message> processor = RingBufferProcessor.share("email-processor", 1024);
Stream<Message> s = Streams.wrap(processor);

s.consume(m -> firstTask(m));
s.consume(m -> secondTask(m));
s.consume(m -> thirdTask(m));