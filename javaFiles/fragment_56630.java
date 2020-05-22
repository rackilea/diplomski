public class RequestManager {

           public static class requestPostExample extends AsyncTask<String, Void, String>{

               Context context;
               int exampleId;
               String exampleData;
               //interface to get the response in the activity
               Public AsynkTaskRespone response = null;

               public requestPostExample(Context context, int exampleID, String exampleData){
                    this.context = context;
                    this.exampleId = exampleID;
                    this.exampleData = exampleData;
                 }

               @Override
               protected String doInBackground(String... params) {
                   try {
                       String urlString = "yourUrl";
                       URL url = new URL(urlString);
                       //the variables and data you want to send by POST
                       String postData = "exampleID="+exampleID+"&exampleData="+exampleData;
                       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                       connection.setDoOutput(true);
                       connection.setRequestMethod("POST");

                       OutputStream os = connection.getOutputStream();
                       os.write(postData.getBytes());

                       StringBuilder responseSB = new StringBuilder();

                       int result = connection.getResponseCode();
                       BufferedReader br;

                       // 401 - 422 - 403  - 500
                      if (result == 401 || result == 422 || result == 403 || result == 404 || result == 500){
                          br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                      }else {
                           br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                      }

                      while ( (JSON_STRING = br.readLine()) != null)
                      responseSB.append(JSON_STRING+ "\n");

                      // Close streams
                      br.close();

                      return responseSB.toString().trim();

                     } catch (Exception e) {
                         e.printStackTrace();
                     }
               return null;
               }
           }

           @Override
            protected void onPostExecute(String result) {
                 Log.d("Result:", result);
                 //send the result to interface;    
                 response.resultPostExample(result);
            }

}