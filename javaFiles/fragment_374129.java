protected void onPostExecute(String result) {
    txtOutput.setText(result);

    new Handler().postDelayed(new Runnable(){
        public void run() {
            txtOutput.setText("");
        }
    }, 10000);        
}