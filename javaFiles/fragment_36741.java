import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Comment {

    private String author;

    private String email;

    @JsonIgnore
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Comment comment = new Comment();
        comment.setAuthor("anAuthor");
        comment.setEmail("email@example.com");

        try {
            System.out.println(objectMapper.writeValueAsString(comment));

            String json = "{\"author\":\"anAuthor\",\"email\":\"another@email.com\"}";
            Comment fromJson = objectMapper.readValue(json, Comment.class);

            System.out.println("Result from Json: author= " + fromJson.getAuthor() + ", email= " + fromJson.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}