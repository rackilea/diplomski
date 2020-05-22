public class LoginTask extends AsyncTask {

    @Override
    void onPreExecute() {

        //Some code to preexecute in Main Thread
        System.out.println("OnPreExecute - Main Thread: " + Platform.isFxApplicationThread());
    }

    @Override
    void doInBackground() {

        //Some code to execute in background thread as internet requests
        System.out.println("doInBackground - Main Thread: " + Platform.isFxApplicationThread());
    }

    @Override
    void onPostExecute() {

        //Some code to execute in Main thread after background process has done, like update a view
        System.out.println("onPostExecute - Main Thread: " + Platform.isFxApplicationThread());        
    }

}