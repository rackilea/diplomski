// Create your mapper
ModelMapper modelMapper = new ModelMapper();

// Create a TypeMap for your mapping
TypeMap<Order, OrderDTO> typeMap = 
    modelMapper.createTypeMap(Order.class, OrderDTO.class);

// Define the mappings on the type map
typeMap.addMappings(mapper -> {
    mapper.map(src -> src.getBillingAddress().getStreet(), 
                      OrderDTO::setBillingStreet);
    mapper.map(src -> src.getBillingAddress().getCity(), 
                      OrderDTO::setBillingCity);
});