public class PlayDevEnvironment implements Environment, LocalServerEnvironment {

    ...

    @Override
    public Map<String, Object> getAttributes() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(LocalEnvironment.REQUEST_END_LISTENERS, new ArrayList<RequestEndListener>());
        return hashMap;
    }
}