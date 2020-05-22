package my.skul;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CheckClassroom extends IntentService {

            /**
             * A constructor is required, and must call the super IntentService(String)
             * constructor with a name for the worker thread.
             */
            public CheckClassroom() {
                super("CheckClassroom");
            }

            /**
             * The IntentService calls this method from the default worker thread with
             * the intent that started the service. When this method returns,
             * IntentService stops the service, as appropriate.
             */
            @Override
            protected void onHandleIntent(Intent intent) {





            }
            private DbHelper ourHelper;
            private SQLiteDatabase ourDatabase;

            @Override
            public void onCreate() {
                ourHelper = new DbHelper();
                ourDatabase = ourHelper.getWritableDatabase();
            }

            @Override
            public void onDestroy() {
                ourHelper.close();
            }

            private class DbHelper extends SQLiteOpenHelper {

                public DbHelper() {
                    super(CheckClassroom.this, "myschool", null, 1);
                    // TODO Auto-generated constructor stub
                }

                @Override
                public void onCreate(SQLiteDatabase arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
                    // TODO Auto-generated method stub

                }
            }
            /* not sure what that is... 
            getColumns()
            {
                //retrieve sqlitedatabase data

            }
            */
}