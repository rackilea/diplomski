import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Toast.makeText(context, "here i want use GetNotifications", Toast.LENGTH_SHORT).show();
        new GetNotifications(context).execute();

    }



    private class GetNotifications extends AsyncTask<Void, Void, Void> {
        private Context context;
        public GetNotifications(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }


        @Override
        protected Void doInBackground(Void... arg0) {


            return null;
        }

    }
}