public enum AdminRole {
    ADMIN("ADMIN"),
    ORGANIZATION_ADMIN("ORGANIZATION_ADMIN");

    private String value;

    AdminRole(String value) {
        this.value = value;
    }
}