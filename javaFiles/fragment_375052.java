public abstract class IdResourceSupportMixin extends ResourceSupportMixin {

    @Override
    @JsonIgnore(false)
    public abstract Link getId();
}