import com.google.protobuf.TextFormat;
import sub.optimal.MediatorMessage.MediatorMessageMsg;

class Check {
    public static void main(String...args) {
        MediatorMessageMsg.Builder builder = MediatorMessageMsg.newBuilder();
        MediatorMessageMsg msg = builder.setSpeed(42.0)
                .setHeading(0.0)
                .setSender("foobar")
                .build();

        System.out.println(TextFormat.shortDebugString(msg));
    }
}