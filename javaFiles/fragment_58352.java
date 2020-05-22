@PreRemove
private void preRemove() {
    if (!activities.isEmpty()) {
        throw new LinkedActivityExistsException();
    }
}