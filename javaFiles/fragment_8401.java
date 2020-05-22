@Valid
@ConvertGroup.List( {
    @ConvertGroup(from=New.class, to=Pk.class),
    @ConvertGroup(from=LocationGroup.class, to=Pk.class)
} )
// Other constraints
private BuildingDto building;