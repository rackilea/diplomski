@Before
private void init(){
   MockitoAnnotations.initMocks(this);
}    

@Mock
JWK jWK;

@Test
public void saveToken() {
    when(jWKRepository.findGlobalJWK(null)).thenReturn(jWK);
    ...
}