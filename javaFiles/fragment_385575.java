@Test
public void whenFindAll_thenReturnCustomerList() {
    Provider provider = providerInit.buildProvider();
    ProviderDTO dto = providerInit.buildProviderDTO();
    List<Provider> providerList = Collections.singletonList(provider);

    when(providerRepository.findAll()).thenReturn(providerList);
    when(providerMapper.toDto(any(Provider.class))).thenReturn(dto);

    Optional<List<ProviderDTO>> result = providerService.getAllProvider();

    assertEquals(1, result.get().size()); // check size
    assertEquals(dto, result.get().get(0)); // check dto result
    Mockito.verify(providerMapper).toDto(provider); //verify the mapper
}