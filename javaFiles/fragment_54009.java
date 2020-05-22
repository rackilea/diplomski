public class Model {
    private String id;
    private String description;
    public char[] name;

    public Model()
    {

    }
    public Model (String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", id)).append(" - ").append(description);
        return sb.toString();
    }

}