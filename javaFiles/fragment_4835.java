@PreUpdate
@PrePersist
public void updateTimeStamps() {
    lastModified = new Date();
    if (dateCreated==null) {
      dateCreated = new Date();
    }
}