public class Item {
private String id;
private String uploaded;
private String updated;
private String uploader;
private String category;
private String title;
private String description;
private Map<Integer, String>  content;

public Map<Integer, String> getContent() {
    return content;
}
}