@Test
 public void testAdapt() {
   SearchHit mockedHit = mock(SearchHit.class);

   Map<String, Object> resonseForGetSource = new HashMap<>();
   resonseForGetSource.put("productgroupid", "12877"); 
   ...

   doReturn(resonseForGetSource).when(mockedHit.getSource());

   ProductAdapterService underTest = ...
   underTest.adapt(mockedHit, true);
   ... probably some asserts