@Entity
public class Article {

    @Id
    @GeneratedValue
    private long id;

    @AssociationOverride(name = "stringMap", joinTable = @JoinTable(name = "title_stringMap"))
    @Embedded
    private LocalizedString title;

    @AssociationOverride(name = "stringMap", joinTable = @JoinTable(name = "text_stringMap"))
    @Embedded
    private LocalizedString text;

    // getters, setters
}