@PrePersist
    public void generateId() {
        if(id != null)
            id = IdGeneratorHolder.getIdGenerator(getClass()).generate();
    }
}