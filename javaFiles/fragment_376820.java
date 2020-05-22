private void weatherRequest(){
    EditText etCity,etMetric;

    etCity= findViewById(R.id.etCity);
    etMetric= findViewById(R.id.etMetric);

    String city= etCity.getText().toString();
    String unit= etCity.getText().toString();

    if(!unit.equals("imperial"))
        unit="metric";

    String url = "http://api.openweathermap.org/data/2.5/weather?q="+etCity+"&units="+etMetric+"&appid=OpenWeatherMapAPIKey";

    //now request the server with this url
}