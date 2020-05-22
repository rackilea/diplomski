import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesis.AmazonKinesisClient;
import com.amazonaws.services.kinesis.model.PutRecordsRequest;
import com.amazonaws.services.kinesis.model.PutRecordsRequestEntry;
import com.amazonaws.services.kinesis.model.PutRecordsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KinesisToKinesis {

    private LambdaLogger logger;
    final private AmazonKinesisClient kinesisClient = new AmazonKinesisClient();

    public PutRecordsResult eventHandler(KinesisEvent event, Context context) {
        logger = context.getLogger();
        if (event == null || event.getRecords() == null) {
            logger.log("Event contains no data" + System.lineSeparator());
            return null;
        } else {
            logger.log("Received " + event.getRecords().size() +
                " records from " + event.getRecords().get(0).getEventSourceARN() + System.lineSeparator());
        }

        final Long startTime = System.currentTimeMillis();

        // set up the client
        Region region;
        final Map<String, String> environmentVariables = System.getenv();
        if (environmentVariables.containsKey("AWS_REGION")) {
            region = Region.getRegion(Regions.fromName(environmentVariables.get("AWS_REGION")));
        } else {
            region = Region.getRegion(Regions.US_WEST_2);
            logger.log("Using default region: " + region.toString() + System.lineSeparator());
        }
        kinesisClient.setRegion(region);

        Long elapsed = System.currentTimeMillis() - startTime;
        logger.log("Finished setup in " + elapsed + " ms" + System.lineSeparator());

        PutRecordsRequest putRecordsRequest = new PutRecordsRequest().withStreamName("usagecounters-global");
        List<PutRecordsRequestEntry> putRecordsRequestEntryList = event.getRecords().parallelStream()
            .map(r -> new PutRecordsRequestEntry()
                    .withData(ByteBuffer.wrap(r.getKinesis().getData().array()))
                    .withPartitionKey(r.getKinesis().getPartitionKey()))
            .collect(Collectors.toList());

        putRecordsRequest.setRecords(putRecordsRequestEntryList);

        elapsed = System.currentTimeMillis() - startTime;
        logger.log("Processed " + putRecordsRequest.getRecords().size() +
            " records in " + elapsed + " ms" + System.lineSeparator());

        PutRecordsResult putRecordsResult = kinesisClient.putRecords(putRecordsRequest);
        elapsed = System.currentTimeMillis() - startTime;
        logger.log("Forwarded " + putRecordsRequest.getRecords().size() +
                " records to Kinesis " + putRecordsRequest.getStreamName() +
                " in " + elapsed + " ms" + System.lineSeparator());
        return putRecordsResult;
    }
}