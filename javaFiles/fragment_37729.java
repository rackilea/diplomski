public class HttpClientWeatherStatusService implements WeatherStatusService {
    private final HttpClient httpClient;

    public HttpClientWeatherStatusService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public WeatherStatus getWeatherStatus(String location) {
        //Setup request.
        //Make request with the injected httpClient.
        //Parse response.
        return new WeatherStatus(temperature, humidity, weatherType);
    }
}