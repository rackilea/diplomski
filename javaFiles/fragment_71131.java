resolvers.add(r -> r.getParam1() != null ? getUserByParam1(r.getParam1()) : null);
resolvers.add(r -> {
    if(r.getFirstName() == null && r.getLastName()) return null;
    return getUserByName(r.getFirstName(), r.getLastName());
});
// etc.