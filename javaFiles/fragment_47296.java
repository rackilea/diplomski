String name = "";
final Bundle bundle = new Bundle();

new findCar(new OnCarListener()
{
    @Override
    public void onCarCompleted(String name) {

        Log.d("AsyncTask", "AsyncTask completed");  
        Log.d("AsyncTask", name);
        bundle.putString(name);
        // do something with the bundle here
    }

    @Override
    public void onCarError(String error) {
    }
}).execute(idCar);