@Entity
public class MyPoJo () {
// all fields
@JsonIgnore
private String batchId;

// getters and setters

@Override
public String toString() {
        // Exception handling code not added
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
     }
}