@PrePersist
@PreUpdate
public void prePersistOrUpdate() {
    setCreatedDate(LocalDateTime.now());
    setModifiedDate(LocalDateTime.now());
    validateEntity();
}