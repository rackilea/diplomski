@Entity
@Indexed
public class Document {

    @Id
    @DocumentId
    private Long id;

    @Field
    private String name;

    private Instant creationTimestamp;

    @Field(analyze = Analyze.NO)
    @Facet
    @javax.persistence.Transient
    public Long getCreationForFaceting() {
        return creationTimestamp == null ? null : creationTimestamp.toEpochMilli();
    }
}