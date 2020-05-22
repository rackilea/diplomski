@Inject
private BoundConversationContext boundConversationContext;

public void onMessage(Message message) {
    BoundRequest boundRequest = null;
    try {
        boundRequest = new MutableBoundRequest(new HashMap<String, Object>(), new HashMap<String, Object>());
        boundConversationContext.associate(boundRequest);
        if (!boundConversationContext.isActive())
            boundConversationContext.activate();
        // DO YOUR BUSINESS LOGIC HERE
    } finally {
        if (boundConversationContext != null) {
            if (boundRequest != null)
                boundConversationContext.dissociate(boundRequest);
            if (boundConversationContext.isActive()) {
                boundConversationContext.deactivate();
            }
        }
    }   
}