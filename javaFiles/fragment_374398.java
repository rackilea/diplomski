private int foreignId;

@Basic
@Column(name = "foregn_id")
public int getForeignId() { return foreignId;}
public void setForeignId(int id) { this.foreignId = id; }

private DBForeignEntity foreignEntity;  

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "foregn_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
public final DBForeignEntity getForeignEntity() {
    if (foreignEntity instanceof HibernateProxy) {
        foreignEntity = getFromCache(foreignId);
    }
    return foreignEntity;
}

public void setForeign(DBForeignEntity foreignEntity) {
    this.foreignEntity = foreignEntity;   
}