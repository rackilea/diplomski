OperationExecutor<T extends Operation<S>> extends AsyncTask<T,Void,S>{
    @Override
    protected S doInBackground(T... params) {
       return null;
    }
}