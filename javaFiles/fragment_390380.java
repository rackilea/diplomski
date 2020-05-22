@PrePersist
protected void onCreate() {
    createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
    updatedAt = new Date();
}