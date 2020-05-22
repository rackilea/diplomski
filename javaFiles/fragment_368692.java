import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.s3.S3Client;

public class Example implements RequestHandler<Void, Void> {

    @Override
    public Void handleRequest(Void nothing, Context ctx) {
        long start = System.currentTimeMillis();
        S3Client s3Client= S3Client.create();
        ctx.getLogger().log("Creating S3 client took " + (System.currentTimeMillis() - start) + "ms");
        ...
        return null;
    }
}