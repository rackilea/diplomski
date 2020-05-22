@Embeddable
public class MetaData{

    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty(access = Access.READ_ONLY)
    private Date createdOn;

    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty(access = Access.READ_ONLY)
    private Date modifiedOn;
}