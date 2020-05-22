public class TeqniRTMPClient {

    private static final Logger logger = LoggerFactory.getLogger(MyRtmpClient.class);

    public static void main(String args[]) throws IOException {
        TeqniRTMPClient client = new TeqniRTMPClient("localhost", 1935, "oflaDemo", "myStream");
        client.recordStream();
    }

    private RTMPClient client;

    private ITagWriter writer;

    private String sourceHost;

    private int sourcePort;

    private String sourceApp;

    private String sourceStreamName;

    private int lastTimestamp;

    private int startTimestamp = -1;

    public TeqniRTMPClient(String sourceHost, int sourcePort, String sourceApp,
            String sourceStreamName) {
        super();
        this.sourceHost = sourceHost;
        this.sourcePort = sourcePort;
        this.sourceApp = sourceApp;
        this.sourceStreamName = sourceStreamName;
    }

    public void recordStream() throws IOException {
        client = new RTMPClient();

        String path = "c:\\temp\\out.flv";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }

        FLVService flvService = new FLVService();
        flvService.setGenerateMetadata(true);
        try {
            IStreamableFile flv = flvService.getStreamableFile(file);
            writer = flv.getWriter();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }



        client.setStreamEventDispatcher(new StreamEventDispatcher());
        client.setStreamEventHandler(new INetStreamEventHandler() {
            public void onStreamEvent(Notify notify) {
                System.out.printf("onStreamEvent: %s\n", notify);
                ObjectMap<?, ?> map = (ObjectMap<?, ?>) notify.getCall().getArguments()[0];
                String code = (String) map.get("code");
                System.out.printf("<:%s\n", code);
                if (StatusCodes.NS_PLAY_STREAMNOTFOUND.equals(code)) {
                    System.out.println("Requested stream was not found");
                    client.disconnect();

                }
                else if (StatusCodes.NS_PLAY_UNPUBLISHNOTIFY.equals(code)
                        || StatusCodes.NS_PLAY_COMPLETE.equals(code)) {
                    System.out.println("Source has stopped publishing or play is complete");
                    client.disconnect();

                }
            }
        });
        client.setExceptionHandler(new ClientExceptionHandler() {
            @Override
            public void handleException(Throwable throwable) {
                throwable.printStackTrace();
                System.exit(1);
            }
        });

        client.setConnectionClosedHandler(new Runnable() {
            public void run() {
                if (writer != null) {
                    writer.close();

                }
                System.out.println("Source connection has been closed, proxy will be stopped");
                System.exit(0);
            }
        });

        // connect the consumer
        Map<String, Object> defParams = client.makeDefaultConnectionParams(sourceHost, sourcePort,
                sourceApp);
        // add pageurl and swfurl
        defParams.put("pageUrl", "");
        defParams.put("swfUrl", "app:/Red5-StreamRelay.swf");
        // indicate for the handshake to generate swf verification data
        client.setSwfVerification(true);
        // connect the client
        client.connect(sourceHost, sourcePort, defParams, new IPendingServiceCallback() {
            public void resultReceived(IPendingServiceCall call) {
                System.out.println("connectCallback");
                ObjectMap<?, ?> map = (ObjectMap<?, ?>) call.getResult();
                String code = (String) map.get("code");
                if ("NetConnection.Connect.Rejected".equals(code)) {
                    System.out.printf("Rejected: %s\n", map.get("description"));
                    client.disconnect();
                }
                else if ("NetConnection.Connect.Success".equals(code)) {
                    // 1. Wait for onBWDone
                    client.createStream(new CreateStreamCallback());
                    Object result = call.getResult();
                    System.out.println("Red5ClientTest.main()");
                }
                else {
                    System.out.printf("Unhandled response code: %s\n", code);
                }
            }
        });
    }

    class CreateStreamCallback implements IPendingServiceCallback {

        public void resultReceived(IPendingServiceCall call) {
            System.out.println("resultReceived: " + call);
            int streamId = ((Number) call.getResult()).intValue();
            System.out.println("stream id: " + streamId);
            // send our buffer size request
            if (sourceStreamName.endsWith(".flv") || sourceStreamName.endsWith(".f4v")
                    || sourceStreamName.endsWith(".mp4")) {
                client.play(streamId, sourceStreamName, 0, -1);
            }
            else {
                client.play(streamId, sourceStreamName, -1, 0);
            }
        }

    }

    class StreamEventDispatcher implements IEventDispatcher {

        private int videoTs;

        private int audioTs;

        public void dispatchEvent(IEvent event) {
            System.out.println("ClientStream.dispachEvent()" + event.toString());
            try {



                IRTMPEvent rtmpEvent = (IRTMPEvent) event;
                logger.debug("rtmp event: " + rtmpEvent.getHeader() + ", "
                        + rtmpEvent.getClass().getSimpleName());
                if (!(rtmpEvent instanceof IStreamData)) {
                    logger.debug("skipping non stream data");
                    return;
                }
                if (rtmpEvent.getHeader().getSize() == 0) {
                    logger.debug("skipping event where size == 0");
                    return;
                }

                byte dataType = rtmpEvent.getDataType();
                ITag tag = new Tag();
                tag.setDataType(dataType);
                if (rtmpEvent instanceof VideoData) {
                    VideoData video = (VideoData) rtmpEvent;
                    FrameType frameType = video.getFrameType();
                    videoTs += rtmpEvent.getTimestamp();
                    tag.setTimestamp(videoTs);
                }
                else if (rtmpEvent instanceof AudioData) {
                    audioTs += rtmpEvent.getTimestamp();
                    tag.setTimestamp(audioTs);
                }

                IoBuffer data = ((IStreamData) rtmpEvent).getData().asReadOnlyBuffer();
                tag.setBodySize(data.limit());
                tag.setBody(data);
                try {

                    writer.writeTag(tag);

                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("writting....");



            }
            catch (Exception e) {//IOException
                e.printStackTrace();
            }
        }

    }
}