public class CollectionElementBean {

    /* add more properties on-demand */
    private Object notNull;
    private String notBlank;
    private String email;

    protected CollectionElementBean() {
    }

    @NotNull
    public Object getNotNull() { return notNull; }
    public void setNotNull(Object notNull) { this.notNull = notNull; }

    @NotBlank
    public String getNotBlank() { return notBlank; }
    public void setNotBlank(String notBlank) { this.notBlank = notBlank; }

    @Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}