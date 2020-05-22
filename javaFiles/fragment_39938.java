private class GetServerVerCode extends AsyncTask<Void, Void, Boolean> { 

    @Override 
    protected Boolean doInBackground(Void... params) {
      try {
        String verjson = NetworkTool.getContent(Config.UPDATE_SERVER
                + Config.UPDATE_VERJSON);
        JSONArray array = new JSONArray(verjson);
        if (array.length() > 0) {
            JSONObject obj = array.getJSONObject(0);
            try {
                newVerCode = Integer.parseInt(obj.getString("verCode"));
                newVerName = obj.getString("verName");
            } catch (Exception e) {
                newVerCode = -1;
                newVerName = "";
                return false;
            }
        }
    } catch (Exception e) {

        return false;

    }
    return true;
    } 

    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            int vercode = Config.getVerCode(this);
            if (newVerCode > vercode) {
                doNewVersionUpdate();

            } else {
                notNewVersionShow();
            }
        }
    }
}