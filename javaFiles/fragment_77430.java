public String produce(String lastSourceOffset, final int maxBatchSize, BatchMaker batchMaker)
        throws StageException {
    long[] nextSourceOffset = {0};
    if (lastSourceOffset != null) {
        nextSourceOffset[0] = Long.parseLong(lastSourceOffset);
    }
    final RtmClient client = new RtmClientBuilder(getEndPoint(), getAppKey()).setListener(new RtmClientAdapter() {
        @Override
        public void onEnterConnected(RtmClient client) {

        }
    }).build();
    SubscriptionAdapter listener = new SubscriptionAdapter() {

        @Override
        public void onSubscriptionData(SubscriptionData data) {
            int numRecords = 0;
            for (AnyJson json : data.getMessages()) {
                jsonString = json.toString();
                Record record = getContext().createRecord("some-id::" + nextSourceOffset[0]);
                Map<String, Field> map = new HashMap<>();
                map.put("fieldName", Field.create(jsonString));
                record.set(Field.create(map));
                batchMaker.addRecord(record);
                ++nextSourceOffset[0];
                ++numRecords;

            }
        }

    };