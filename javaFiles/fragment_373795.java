ModelMapper mm = new ModelMapper();
Converter<List<Pojo>, String> goalsToName = 
    ctx -> ctx.getSource() == null ? null : ctx.getSource().get(0).getName();
PropertyMap<Src, Dest> propertyMap = new PropertyMap<>() {
    @Override
    protected void configure() {
        using(goalsToName).map(source.getGoals()).setGoal(null);
    }
};
mm.addMappings(propertyMap);