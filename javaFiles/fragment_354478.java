@Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute (aVoid);
        MainActivity.DATA = data;
        if(DATA!=null){
            textView1.setText (DATA);
        }
    }