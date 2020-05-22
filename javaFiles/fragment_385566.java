private JSONObject result;
public JSONObject getResult() {
    return result;
}

@Override
protected void onPostExecute(JSONObject result)  {
    this.result = result;
    if(result != null) {
        try {
            this._finished.call();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}