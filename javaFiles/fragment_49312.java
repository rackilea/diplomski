static ResponseB convertBEntityToDtoExplicitTypeMap(ModelB modelB){
    ModelMapper modelMapper = new ModelMapper();
    TypeMap<ModelB, ResponseB> typeMap = modelMapper.createTypeMap(ModelB.class, ResponseB.class);

    typeMap.addMappings(mapping -> {
        mapping.map(ModelB::getId, ResponseB::setId);
        mapping.map(ModelB::getBankaccountName, ResponseB::setB);
        mapping.map(ModelB::isActive, ResponseB::setActive);
    });

    return modelMapper.map(modelB, ResponseB.class);
}