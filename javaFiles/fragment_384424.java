public class NotificationProcessor {
    @Autowired
    private Averager averager;

    @Autowired
    private TrendAnalyser trendAnalyser;

    private long prevNotificationTime;

    public void consume(Message message, Queue<Notification> queue) {


        if (message.getRate() >  averager.getAverage() + THRESHOLD) {
            // Generate notification A here
            queue.add(…);
        }

        // Adjust the moving average
        averager.put(message);

        trendAnalyser.analyze(message);
        if (trendAnalyser.isFalling()) {
            Date now  = new Date();
            // Throttle
            if (now.getTime() - prevNotificationTime > 60) {
                prevNotificationTime = now.getTime();
                // Generate notification B here
                queue.add(…);
            }
        }
    }
}