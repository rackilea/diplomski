public class ServiceManager {
    private static final String METHOD_NAME = "GetHotels";
    private static final String NAMESPACE = "http://tempuri.org/";
    private static final String SOAP_ACTION = "http://tempuri.org/GetHotels";
    private static final String URL = "http://192.168.1.170/HotelApps_WebServices.asmx";
    public static Context mContext;
    SoapObject soapObject;
    SoapSerializationEnvelope soapSerializationEnvelope;
    HttpTransportSE httpTransportSE;
public ServiceManager(Context context){
    this.mContext = context;//now u can pass mContext to Hotel Constructor
}
    public Hotel[] GetHotels(int Company_id) {

        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapObject.addProperty("Company_id", Company_id);

        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet = true;
        soapSerializationEnvelope.setOutputSoapObject(soapObject);

        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;

        Hotel hotels[]=new Hotel[6];
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive=(SoapPrimitive)soapSerializationEnvelope.getResponse();
            JSONArray jsonHotels = new JSONArray(soapPrimitive.toString());

            for (int i=0; i<6; i++) {
                hotels[i]=new Hotel( mContext, jsonHotels.getJSONObject(i).getString("Hotel_id"),jsonHotels.getJSONObject(i).getString("Hotel_Name"), jsonHotels.getJSONObject(i).getString("Company_id"));

            }
            return hotels;
        } catch (Exception ex) {
            ex.printStackTrace();
            return hotels;
        }
    }

}