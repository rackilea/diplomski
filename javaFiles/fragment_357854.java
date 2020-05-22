public class GetData extends AsyncTask<String, Integer, Map<String, String>> {
    @Override
    protected Map<String, String> doInBackground(String... params) {
        //do your thing here
        return resultMap;
    }
    @Override
    protected void onPostExecute(Map<String, String> result) {
        StorageClass.setArrayData(result);
    }
}