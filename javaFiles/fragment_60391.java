public void onBindViewHolder(final ViewHolder holder, final int position) {

    final ChatMessage msg = mMessagesList.get(position);
    holder.messageTextView.setText(msg.getMessage());

    new LongOperation(holder,msg.getMessage()).execute();


}




private class LongOperation extends AsyncTask<String, Void, String> {

    private WeakReference<ViewHolder> holder; 
    private String message;      

    LongOperation(ViewHolder viewholder, String message){
        holder = new WeakReference<ViewHolder>(viewholder);
        this.message = message;
    }
    @Override
    protected String doInBackground(String... str) {
        //do all your background stuff here
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(holder.get() != null){
            holder.get().messageTextView.setText(message);
        }
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}