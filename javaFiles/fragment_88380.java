public class MyClass extends Activity {

    private class myTask extends AsyncTask<Void, Void, Void> {

        //initiate vars
        public myTask() {
            super();
            //my params here
        }

        protected Void doInBackground(Void... params) {
            //do stuff
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //do stuff
            myMethod(myValue);
        }
    }

    private myHandledValueType myMethod(Value myValue) {
        //handle value 
        return myHandledValueType;
    }
}