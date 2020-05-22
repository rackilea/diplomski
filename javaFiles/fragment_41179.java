@ApplicationScoped
public class ActionMapFactory {

    @Inject
    private SaveAction saveAction;

    @Inject
    private DeleteAction deleteAction;

    // And so on

    @Produces @Preffered
    public HashMap<String, Action> getHashMap() {
        Map<String, Action> hm = new HashMap<>();
        hm.put("save", saveAction);
        hm.put("delete", deleteAction);
        return hm;
    }
}