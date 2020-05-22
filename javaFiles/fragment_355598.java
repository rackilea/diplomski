@Entity
public class SomeClass {

    @Lob
    @Column(columnDefinition = "binary(255)")
    private java.net.URL myURL;

    ...
}