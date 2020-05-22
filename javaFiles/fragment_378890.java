@Embeddable
public class BlocRecordId implements Serializable {
  @Column(name = "identifier_")
  String identifier;

  @Column(name = "recordType_")
  String recordType;

  @Column(name = "source_")
  String source;

  @Column(name = "messageType_")
  String messageType;

  @Transient
  private RecordId recordId;

  /** Helper method to assign the values from an existing RecordId */
  public void setRecordId(RecordId recordId) {
    this.identifier = recordId.getIdentifier();
    this.recordType = recordId.getRecordType();
  }

  /** Helper method to get the RecordId, caching it to avoid multiple allocations */
  public RecordId getRecordId() {
    if ( recordId == null ) {
      this.recordId = new RecordId( identifier, recordType );
    }
    return this.recordId;
  }
}