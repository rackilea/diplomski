@Override
protected void onPostExecute(String result) {
    ArrayList<StructTask> nettasks = new ArrayList<StructTask>();
    try {
        JSONArray tasks = new JSONArray(result);
        for (int i = 0; i < tasks.length(); i++) {
            JSONObject object = tasks.getJSONObject(i);
            StructTask task = new StructTask();
            task.setid(object.getLong("task_id"));
            task.settitle(object.getString("task_title"));
            task.setdesc(object.getString("task_desc"));
            task.setdone(object.getInt("task_done"));
            nettasks.add(task);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }