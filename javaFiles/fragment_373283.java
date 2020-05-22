public String listConditions(String header, WeatherFormatter weatherFormatter) {
    String retVal = "";
    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
    for(Map.Entry<String , ArrayList<Weather>> entry : this.weathers.entrySet()) {
        retVal = String.format("\n Data From %s \n", entry.getKey());
        retVal += header;
        for (Weather element : this.weathers.get(entry.getKey())) {
            retVal += weatherFormatter.formatWeather(weather);
        }
    }
    retVal += "--------------------";
    return retVal;
}