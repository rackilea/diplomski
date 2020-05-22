public abstract class AsyncTask {

    abstract void onPreExecute();

    abstract void doInBackground();

    abstract void onPostExecute();

    public void execute() {

        onPreExecute();

        new Thread(new Runnable() {
            @Override
            public void run() {

                doInBackground();

                //Platform.runLater is a javafx code that executes onPost in Main Thread.
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        onPostExecute();
                    }
                });
            }
        }).start();
    }
}