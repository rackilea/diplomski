public class BuildingDto {

    @NotNull(groups = {Pk.class, Existing.class, LocationGroup.class})
    // Other constraints
    private Integer id;

    //
}