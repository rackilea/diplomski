@Override
public void onPreExecute() {
    super.onPreExecute();

    Log.d("GCM", "onPreExecute: called");
}

@Override
public void onPostExecute(String resultOfDoInBackground) {
    super.onPostExecute(resultOfDoInBackground);

    Log.d("GCM", "onPostExecute: called");
}