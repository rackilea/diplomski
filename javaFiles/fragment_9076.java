public class ConsumerListener implements Runnable {

    private final Consumer<String, String> consumer = new KafkaConsumer<>(properties);

    @Override
    public void run() {
        try {
            consumer.subscribe(topics);

            while (true) {
                    // consume
                }
            }
        } finally {
            consumer.close();
        }
    }
}