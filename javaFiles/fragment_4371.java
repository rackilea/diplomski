public abstract class CommonDomainObject {
    ...
    @JsonIgnore
    public boolean isNew() {
        return null == getId();
    }
}