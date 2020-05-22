private Map<String, Action> actionMap;

// This is part of the CDI bean contract
protected ActionMapFactory() {}

@Inject
public ActionMapFactory(SaveAction saveAction, DeleteAction deleteAction) {
    actionMap = new HashMap<>();
    actionMap.put("save", saveAction);
    actionMap.put("delete", deleteAction);
}

@Produces @Preffered
public HashMap<String, Action> getHashMap() {
    return actionMap;
}