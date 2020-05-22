@Component
public class SQSHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down()
              .withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    public int check() {
        /**
        your logic to check queue exists or not using by calling getQueueUrl . e.g you will get queue url of a queue named "SampleQueue" like https://sqs.us-east-1.amazonaws.com/12XXX56789XXXX/SampleQueue
        **/
        return 0; // 0 or 1 based on result
    }
    }