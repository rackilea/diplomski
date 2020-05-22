@PrePersist
void generateId() {
    if (uniq_name == null) {
        uniq_name = GENERATE_SOME_UNIQUE_ID_SO_IT_DOESN'T_BREAK();
    }
}