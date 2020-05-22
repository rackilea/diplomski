@MappedSuperclass
public abstract class AbstractAuditModel extends AbstractModel {

    @CreatedDate
    @Column(nullable = false)
    protected Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    protected Date lastModifiedAt;

}