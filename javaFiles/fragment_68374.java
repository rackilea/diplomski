@Embeddable
class RelationABId implements Serializable {
    private Long entityAId;
    private Long entityBId;

    public RelationABId() {
    }

    public RelationABId(Long entityAId, Long entityBId) {
        this.entityAId = entityAId;
        this.entityBId = entityBId;
    }

    public Long getEntityAId() {
        return entityAId;
    }

    public void setEntityAId(Long entityAId) {
        this.entityAId = entityAId;
    }

    public Long getEntityBId() {
        return entityBId;
    }

    public void setEntityBId(Long entityBId) {
        this.entityBId = entityBId;
    }
}

@Entity
class RelationABEntity {

    @EmbeddedId
    private RelationABId id;

    public RelationABEntity() {
    }

    public RelationABEntity(Long entityAId, Long entityBId) {
        this.id = new RelationABId(entityAId, entityBId);
    }

    public RelationABId getId() {
        return id;
    }

    public void setId(RelationABId id) {
        this.id = id;
    }
}