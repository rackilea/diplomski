import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public class Hello implements RequestHandler<S3Event, Void> {
    @Override
    public Void handleRequest(S3Event s3event, Context context) {
        try {
            S3EventNotificationRecord record = s3event.getRecords().get(0);

            String bkt = record.getS3().getBucket().getName();
            String key = record.getS3().getObject().getKey().replace('+', ' ');
            key = URLDecoder.decode(key, "UTF-8");
       } catch (Exception e) {
           // do something
       }
       return null;
    }
}