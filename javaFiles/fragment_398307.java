ModelMapper modelMapper = new ModelMapper();
modelMapper.addMappings(new PropertyMap<Order, OrderDTO>() {
  @Override
  protected void configure() {
    map().setBillingStreet(source.getBillingAddress().getStreet());
    map().setBillingCity(source.getBillingAddress().getCity());
  }
});