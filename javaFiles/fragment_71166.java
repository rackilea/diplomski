@ViewScoped
public class TestBean implements Serializable {

    private static final String CDI_PUSH_TOPIC = "pushCdi";
    private String userIdentifier;
    @Inject
    @Push(topic = CDI_PUSH_TOPIC, subtopic = "#{testBean.userIdentifier}")
    private javax.enterprise.event.Event<String> pushEvent;

    @PostConstruct
    public void init() {

        if (userIdentifier == null) {
            userIdentifier = UUID.randomUUID().toString().replace("-", "");
        }

        TopicsContext topicsContext = TopicsContext.lookup();
        topicsContext.getOrCreateTopic(new TopicKey(CDI_PUSH_TOPIC, userIdentifier));
    }

    public void sendMessage() throws Exception {
        Log.log("sendMessage");
        pushEvent.fire("a test message");
    }

    // add getters & setters