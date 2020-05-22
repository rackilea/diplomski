import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Department {

    @Id
    private String id;

    @DBRef
    private Collection<Employee> employees;
    ...
}