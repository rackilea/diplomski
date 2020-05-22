public class DataCollectClass extends AsyncTask<Object, Void, JSONObject> {

    public interface OnDataCollectedCallback{
        void onDataCollected(JSONObject data);
    }

    private OnDataCollectedCallback mCallback;

    public DataCollectClass(OnDataCollectedCallback callback){
        mCallback = callback;
    }

    // your code that is already there
    ...

    @Override
    public onPostExecute(JSONObject response){
        if(mCallback != null)
            mCallback.onDataCollected(response);
    }
}