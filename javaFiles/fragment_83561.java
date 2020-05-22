@Test
public void getDataTest() {
    WeatherData getWeatherDataResponse = Mockito.mock(WeatherData.class);
    when(connector.newGetWeatherDataCall()).thenReturn(getWeatherDataResponse);
    when(getWeatherDataResponse.call(Matchers.any(Class.class))).thenReturn(new ServiceData());
    assertNotNull(service.getData("123"));
}