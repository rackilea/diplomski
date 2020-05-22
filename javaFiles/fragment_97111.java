ProducerSettings<String, CustomObject> producerSettings = ProducerSettings.create(system, new StringSerializer(), new CustomObjectSerializer());
objectQueryTopic().subscribe().atLeastOnce(
Flow.fromSinkAndSource(
    Flow.fromFunction(this::deserializeCommandAndQueryObjects)
        .mapAsync(concurrency, objects -> objects)
        .flatMapMerge(concurrency, objects -> objects)
        .alsoTo(Sink.foreach(object -> LOG.trace("Sending event {}", object)))
        .map(object -> new ProducerRecord<String, CustomObject>(OBJECTS_RESULT_TOPIC, object))
        .to(Producer.plainSink(producerSettings)),
    Source.repeat(Done.getInstance())));