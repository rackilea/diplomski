public WeatherStatusServiceTests {
    @Test
    public void givenALocation_WhenAWeatherStatusRequestIsMade_ThenTheCorrectStatusForThatLocationIsReturned() {
        //SETUP TEST.
        //Create httpClient mock.
        String location = "The World";
        //Create expected response.
        //Expect request containing location, return response.
        WeatherStatusService service = new HttpClientWeatherStatusService(httpClient);
        //Replay mock.

        //RUN TEST.
        WeatherStatus status = service.getWeatherStatus(location);

        //VERIFY TEST.
        //Assert status contains correctly parsed response.
    }
}