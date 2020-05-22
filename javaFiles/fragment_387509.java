public class ValueByKey implements RemovalListener<String, Long> { 
    //...
    @Override
    public void onRemoval(RemovalNotification<String, Long> notification) {
        System.out.println("removed: " + notification.getKey() + " -> " + notification.getValue());
    }
    //...
}