@Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (k==-1){
            Toast.makeText(getApplicationContext(), "Same raws", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "not same raws", Toast.LENGTH_SHORT).show();
        }
    }