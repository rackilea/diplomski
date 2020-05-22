import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatchlogs.CloudWatchLogsClient;
import software.amazon.awssdk.services.cloudwatchlogs.model.DescribeLogStreamsRequest;
import software.amazon.awssdk.services.cloudwatchlogs.model.DescribeLogStreamsResponse;
import software.amazon.awssdk.services.cloudwatchlogs.model.InputLogEvent;
import software.amazon.awssdk.services.cloudwatchlogs.model.PutLogEventsRequest;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

    @Value("${application.name}")
    private String applicationName;

    @Value("${aws.logGroupName}")
    private String logGroupName;

    @Value("${aws.logStreamName}")
    private String logStreamName;


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex, HandlerMethod handlerMethod, HttpServletRequest request) throws JsonProcessingException {
        Class ControllerName = handlerMethod.getMethod().getDeclaringClass();
        String MethodName = handlerMethod.getMethod().getName();
        ErrorResponse error = new ErrorResponse();

        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setErrorMessage(ex.getMessage());
        error.setControllerName(ControllerName.toString());
        error.setServiceName(MethodName.toString());
        error.setTimeStamp(sdf.format(System.currentTimeMillis()));
        error.setProjectName(applicationName);
        error.setServicePath(request.getRequestURL().toString());
        PutLogEvents(error);

        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }

    public void PutLogEvents(ErrorResponse Er) throws JsonProcessingException {
        String regionId = "xxxxx";
        String logGroupName = "xxxxx";
        String logStreamName = "xxxxx";

        CloudWatchLogsClient logsClient = CloudWatchLogsClient.builder().region(Region.of(regionId)).build();
        // A sequence token is required to put a log event in an existing stream.
        // Look up the stream to find its sequence token.
        String sequenceToken = getNextSequenceToken(logsClient, logGroupName, logStreamName);

        // Build a JSON log using the EmbeddedMetricFormat.

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(Er);

        String message =json;
        InputLogEvent inputLogEvent = InputLogEvent.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();

        // Specify the request parameters.
        PutLogEventsRequest putLogEventsRequest = PutLogEventsRequest.builder()
                .logEvents(Arrays.asList(inputLogEvent))
                .logGroupName(logGroupName)
                .logStreamName(logStreamName)
                // Sequence token is required so that the log can be written to the
                // latest location in the stream.
                .sequenceToken(sequenceToken)
                .build();

        logsClient.putLogEvents(putLogEventsRequest);
    }

    private static String getNextSequenceToken(CloudWatchLogsClient logsClient, String logGroupName, String logStreamName) {
        DescribeLogStreamsRequest logStreamRequest = DescribeLogStreamsRequest.builder()
                .logGroupName(logGroupName)
                .logStreamNamePrefix(logStreamName)
                .build();

        DescribeLogStreamsResponse describeLogStreamsResponse = logsClient.describeLogStreams(logStreamRequest);

        // Assume that a single stream is returned since a specific stream name was
        // specified in the previous request.
        return describeLogStreamsResponse.logStreams().get(0).uploadSequenceToken();
    }

}