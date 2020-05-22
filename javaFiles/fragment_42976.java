@Named("foo")
@ConversationScoped
public class FooBean implements Serializable {

    @Inject
    Conversation conversation;

    public String getConversationId() {
        return conversation.getId();
    }

    @PostConstruct
    public void init() {
        conversation.begin();
    }

    // ...
}

@Path("foo")
@ConversationScoped
public class FooResource implements Serializable {

    @Inject
    FooBean fooBean;

    @GET
    @Path("myMethod")
    public String myMethod() {
        // ...
    }
}