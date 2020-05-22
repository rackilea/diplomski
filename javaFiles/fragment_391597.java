class MyClass {
    Button b;
    boolean flag = false;
    // Stuff

    class MyAsyncClass extends AsyncTask {
        // All the stuff, core work in doInBackground

        @Override
        void onPostExecute(/*vars*/) {
            b.setText("Done");
            flag = true;
        }
    }
}