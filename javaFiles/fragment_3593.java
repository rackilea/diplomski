public class IdProvider {

    private final Map<String,AtomicLong> idMap;

    public IdProvider(){
        idMap = new HashMap<>();
    }

    public synchronized long getAvailableId(String conversation){
        AtomicLong id = idMap.get(conversation);
        if(id == null){
            id = new AtomicLong(0);
            idMap.put(conversation,id);
        }
        return id.getAndIncrement();
    }


}