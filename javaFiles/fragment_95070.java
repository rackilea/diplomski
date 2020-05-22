package com.axis.weather;

import static com.axis.weather.WeatherServiceStub.*;

public class Main {
    public static void main(String[] args) {
        Weather w = new Weather();
        w.setHowMuchRain(2.2f);

        SetWeather wrapper = new SetWeather();
        wrapper.setArgs0(w);

        try {
            WeatherServiceStub stub = new WeatherServiceStub(); // will use http://localhost:8080/axis2/services/WeatherService.WeatherServiceHttpSoap12Endpoint/
            stub.setWeather(wrapper);
        } catch (java.rmi.RemoteException re) {
            re.printStackTrace();
        }
    }
}