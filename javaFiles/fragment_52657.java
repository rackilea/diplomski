KStream<InputKeyType, InputValueType> stream2 = stream.transform(new TransformerSupplier<InputKeyType, InputValueType, KeyValue<OutputKeyType, OutputValueType>>() {
            @Override
            public Transformer<InputKeyType, InputValueType, KeyValue<OutputKeyType, OutputValueType>> get() {
                return new Transformer<InputKeyType, InputValueType, KeyValue<OutputKeyType, OutputValueType>>() {
                    private ProcessorContext context;

                    @Override
                    public void init(ProcessorContext context) {
                        this.context = context;
                    }

                    @Override
                    public KeyValue<OutputKeyType, OutputValueType> transform(InputKeyType key, InputValueType value) {

                        this.context.topic() // topic name you need
                        // logic here
                        return new KeyValue<>(OutputKeyType key, OutputValueType value);

                    }

                    @Override
                    public void close() {

                    }
                };
            }
        });