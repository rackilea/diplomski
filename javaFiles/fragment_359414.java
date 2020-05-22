public class LocationMap {
    private Map<Floor,Set<User>> = new HashMap<>(); 
    private Map<User,Floor> = new HashMap<>();

    public @CheckForNull Floor getFloorOf( @Nonnull User user ) { ... }

    public @CheckForNull Set<User> getUsersOn( @Nonnull Floor floor ) { ... }

    ...
}