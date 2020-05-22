@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditInfo {

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    @CreatedDate
    private LocalDateTime createdOn;

    @LastModifiedDate
    private LocalDateTime updatedOn;

}