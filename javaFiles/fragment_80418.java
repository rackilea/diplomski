private final String id;

@Inject
public ThingResource(@Assisted String id) {
    this.id = id;
}