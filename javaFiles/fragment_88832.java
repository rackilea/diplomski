public PublishProcessor<Boolean> flowControl = PublishProcessor.create();

public void start() {
    Flowable./*...*/
            .compose(FlowableTransformers.valve(flowControl))
            .subscribe(/*...*/);