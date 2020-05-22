public class CreationReceipt<T> {

    private final String location;
    private final Future<T> attachment;

    public CreationReceipt(String location, Future<T> attachment) {
        this.location = location;
        this.attachment = attachment;
    }

    public String getLocation() {
        return location;
    }

    public Future<T> getAttachment() {
        return attachment;
    }
}