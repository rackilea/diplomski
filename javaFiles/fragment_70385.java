public class BackgroundWorker extends AsyncTask<Context, String, ArrayList<Card>>
{
    Context ApplicationContext;
    Activity mActivity;

   public BackgroundWorker (Activity activity)
   {
     super();
     mActivity = activity;
   }

//rest of code...