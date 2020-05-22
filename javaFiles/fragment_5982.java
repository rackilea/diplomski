private class FetchEmployeesTask extends AsyncTask<Void, Void, List<Employee>> {


    public AsyncResponse delegate = null;

    public  FetchEmployeesTask(AsyncResponse asyncResponse){
        delegate = asyncResponse;
    }


    @Override
    protected List<Employee> doInBackground(Void... voids) {

        return new APIHelper().fetchItems();
    }

    @Override
    protected void onPostExecute(List<Employee> items) {
        employees.addAll(items);
        adapter.notifyDataSetChanged();
        delegate.processFinished(items);

    }
}