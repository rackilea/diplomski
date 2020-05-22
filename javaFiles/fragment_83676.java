MyDAO mockDAO = mock(MyDAO.class);
List<Country> countries = Arrays.asList(new Country(...));
when(mockDAO.getCountries()).thenReturn(countries);
when(mockDAO.getCities((Country) any(Country.class))).thenThrow(new NetworkIsDownException());

MyService underTest = new MyService(mockDAO);
// TODO call underTest.getRandomCityList() and check that it does what it should do.