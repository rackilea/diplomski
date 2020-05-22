public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        String result = "";
        ...

        try {
            ...
            return result;
        } catch (MalformedURLException e1) {
            result= "MalformedURLException";
        } catch (IOException e2) {
            result= "IOException";
        } catch (Exception e) {
            // do nothing and returning empty
            result= "Exception";
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        // check if there is an error
        String errorMessage = "";
        switch(result) {
          case "MalformedURLException":
            errorMessage = "MalformedURLException";
            break;
          case ""IOException":
            errorMessage = "IOException";
            break;
          case "Exception":
            errorMessage = "Exception";
            break;
        }

         // there is an error, show a message.
        if(!errorMessage.isEmpty()) {
            Toast.makeText(MainActivity.this, "Could not find weather: " + errorMessage, Toast.LENGTH_SHORT).show();
            return; // stop the process.
        }

         // do something when no error found.

    }
}