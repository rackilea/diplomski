private BinlistsService binlistsService = Mockito.mock(BinlistsService.class);

Optional<BinLists> binList = null;

@BeforeEach
    public void beforeEachTest() throws IOException {

        BinLists binLists = new BinLists();
        binLists.setId(1);
        ....

        binList = Optional.of(binLists);
    }

    @Test
    public void testBinCountryCheckFilterImpl() {

        when(binlistsService.findByName(anyString())).thenReturn(binList);

}