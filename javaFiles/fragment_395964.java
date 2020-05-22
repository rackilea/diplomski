public class JSONTask extends AsyncTask<String, Void, String> {
       private OnTaskCompleted mOnTaskCompleted;
       private int apiType = 0;

       public JSONTask(int apiType, OnTaskCompleted mOnTaskCompleted) {
         this.apiType = apiType;
         this.mOnTaskCompleted = mOnTaskCompleted;
       }

      @Override
      protected void onPreExecute() {
        super.onPreExecute();
      }

      @Override
      protected String doInBackground(String... params) {
          String api = params[0];

          // make rest call and return valid data to onPostExecute callback.
          return null;
      }

      @Override
      protected void onPostExecute(String result) {
           super.onPostExecute(result);

           //Magic...
           switch (apiType) {
               case Constants.URL_with_API_1:
                    if (mOnTaskCompleted != null) mOnTaskCompleted.onTaskOne(result);
                 break;
               case Constants.URL_with_API_2:
                    if (mOnTaskCompleted != null) mOnTaskCompleted.onTaskTwo(result);
                 break;
              default:
            }
          }
        }