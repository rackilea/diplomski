public class GetWeather extends AsyncTask<Void, Integer, Void> {



    public GetWeather(Activity activity) {
        this.activity = activity;


        context = activity;
        dialog = new ProgressDialog(context);


    }

    /** progress dialog to show user that the backup is processing. */
    private ProgressDialog dialog;
    /** application context. */
    private Activity activity;
    private Context context;



    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();






    }

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub


        GetWeather weather = new GetWeather(strPosition);
        weather.returnWeather();


        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);



                     tvConsole
                .append("Weather Update\n-------------------\n\nCurrent Temp (C): "
                        + weather.strTemp
                        + "C\n"
                        + "Wind is out of the "
                        + weather.strWindDir
                        + " at "
                        + weather.strWindSpeed
                        + " MPH\n"
                        + "Visibility is "
                        + weather.strVisibility
                        + " miles\n\n");

        // Auto-scroll textview
        // Does not function on Android 4.0+
        final Layout layout = tvConsole.getLayout();
        if (layout != null) {
            int scrollDelta = layout.getLineBottom(tvConsole
                    .getLineCount() - 1)
                    - tvConsole.getScrollY()
                    - tvConsole.getHeight();
            if (scrollDelta > 0)
                tvConsole.scrollBy(0, scrollDelta);
        }




                     }



  }