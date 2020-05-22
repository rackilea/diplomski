@Override
protected void onPostExecute(List<Task> tasks) {
    tasks.addAll(tasks);
    //Update listview adapter . Which already has the updated items 
    //assuming your listview adapter variable is listViewAdapter
    listViewAdapter.notifyDataSetChanged();
}