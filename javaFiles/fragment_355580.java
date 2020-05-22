package com.chimeraprime.syncano4libcheck;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.syncano.library.Syncano;
import com.syncano.library.annotation.SyncanoClass;
import com.syncano.library.annotation.SyncanoField;
import com.syncano.library.api.Response;
import com.syncano.library.data.SyncanoObject;

import java.util.List;
import java.util.Random;


public class OtherActivity extends AppCompatActivity {
    private Button btn;
    private Syncano syncano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        syncano = new Syncano("<api_key>", "<instance>");
        btn = (Button) findViewById(R.id.crash);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();

                Book book = new Book();
                book.latitude = rnd.nextFloat();
                book.longitutde = rnd.nextFloat();
                book.altitude = rnd.nextFloat();
                book.force_x = rnd.nextFloat();
                book.force_y = rnd.nextFloat();
                book.force_y = rnd.nextFloat();

                new Network(book, syncano).execute();
            }
        });
    }


    public static class Network extends AsyncTask<String, Void, String> {
        Book b;
        Syncano syn;
        String TAG = Network.class.getSimpleName();

        public Network(Book book, Syncano syncano) {
            this.b = book;
            this.syn = syncano;
        }

        @Override
        protected String doInBackground(String... params) {
            // send object to server
            Response<Book> responseCreateObject = syn.createObject(b).send();
            if (responseCreateObject.getHttpResultCode() == Response.HTTP_CODE_CREATED) {
                Log.d(TAG, "Success. Item created.");
            } else {
                Log.d(TAG, "Fail.");
            }

            // get objects from server
            Response<List<Book>> responseGetObjects = syn.getObjects(Book.class).send();
            if (responseGetObjects.getHttpResultCode() == Response.HTTP_CODE_SUCCESS) {
                List<Book> books = responseGetObjects.getData();
                Log.d(TAG, "Success. Items downloaded: " + books.size());
            } else {
                Log.d(TAG, "Fail.");
            }

            return "Executed";
        }
    }

    @SyncanoClass(name = "ltds")
    public class Book extends SyncanoObject {
        public static final String FIELD_LAT = "latitude";
        public static final String FIELD_LNG = "longitude";
        public static final String FIELD_ALT = "altitude";
        public static final String FIELD_X = "force_x";
        public static final String FIELD_Y = "force_y";
        public static final String FIELD_Z = "force_z";

        @SyncanoField(name = FIELD_LAT)
        public float latitude;

        @SyncanoField(name = FIELD_LNG)
        public float longitutde;

        @SyncanoField(name = FIELD_ALT)
        public float altitude;

        @SyncanoField(name = FIELD_X)
        public float force_x;

        @SyncanoField(name = FIELD_Y)
        public float force_y;

        @SyncanoField(name = FIELD_Z)
        public float force_z;
    }
}