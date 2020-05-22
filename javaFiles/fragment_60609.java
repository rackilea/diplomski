public class GooglePlaces extends AsyncTask {

public InputStream inputStream;


    public GooglePlaces(Context context) {

        String url = "https://www.google.com";


        try {
            HttpRequest httpRequest = requestFactory.buildGetRequest(new GenericUrl(url));
            HttpResponse httpResponse = httpRequest.execute();
            inputStream = httpResponse.getContent();

        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();

        try {
            for (String line = null; (line = bufferedReader.readLine()) != null;) {
                builder.append(line).append("\n");
                Log.i("GooglePlacesTag", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}