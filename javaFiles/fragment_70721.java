public class RestClient<t>  extends AsyncTask<String, String, String> {

private Class<t> tClass;

private t returnGenericObject;
private WebApiReturn webApiReturn;

private AsyncCallback callback;

public RestClient(Class<t> tClass)
{
    //The instance of the class you want
    this.tClass = tClass;
    webApiReturn= new WebApiReturn();
}

//You get the WebApiReturn with this method
public WebApiReturn getWebApiReturn(){
    return webApiReturn;
}

//You get the inside generic object with this method
public Object getObjectResponse(){
    return returnGenericObject;
}


@Override
protected String doInBackground(String... OnlyTheURL) {
    String urlString = OnlyTheURL[0];
    try {
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        connection.connect();

        String result = convertStreamToString(connection.getInputStream()); //A function to convert Stream to String...

        connection.disconnect();

        //Created a JSONObject from the result of the connection
        JSONObject jsonObject = new JSONObject(result);

        //Don't set the Generic Object because it will crash when you try to get back
        webApiReturn.setHasError(jsonObject.getBoolean("hasError"));
        webApiReturn.setErrorMessage (jsonObject.getString("errorMessage"));
        webApiReturn.setErrorCode(jsonObject.getString("errorCode"));

        //Get the String of the generic object within the WebApiReturn
        String obj = jsonObject.get("objetoRetorno").toString();
        //With Gson convert it to the class you expect (that you instanciated in the constructor)
        Gson gson = new Gson();
        ObjetoDeRetorno = gson.fromJson(obj, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}