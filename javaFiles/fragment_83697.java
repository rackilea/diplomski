public class SoapSenderClass{

String SOAP_ACTION = "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP";
String NAMESPACE = "http://ws.cdyne.com/WeatherWS/";
String METHOD_NAME = "GetCityWeatherByZIP";
String URL = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl";


public String getWeather(String zipcode)
{
    try{
    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

    envelope.dotNet = true;

    PropertyInfo property = new PropertyInfo();

    property.setName("ZIP");
    property.setType(String.class);
    property.setValue(zipcode);
    request.addProperty(property);

    envelope.setOutputSoapObject(request);

    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

    androidHttpTransport.call(SOAP_ACTION, envelope);

    SoapObject response = (SoapObject)envelope.getResponse();

    String resultValue = response.toString();

    return resultValue;

} 
catch (Exception e) {
    e.printStackTrace();
    return "Failed to get ID";
}

}
}