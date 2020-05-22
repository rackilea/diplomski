package cyn.assignment4;

import android.text.TextUtils;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Cyn on 10/16/2015.
 */
public class address {
    parcel parcelObject;
    EditText startAdd;
    EditText startZip;
    EditText endAdd;
    EditText endZip;


    double sZip, eZip;

    public  address (Activity activity) {
       startAdd = (EditText)activity.findViewById(R.id.originZip);
        startZip = (EditText)activity.findViewById(R.id.originZip);
        endAdd = (EditText)activity.findViewById(R.id.destAdd);
        endZip = (EditText)activity.findViewById(R.id.destZip);

        String checkUserInput =  startZip.getText().toString();
        if (TextUtils.isEmpty(checkUserInput)) {
            startZip.setError("You must enter a valid zip code");
        }
        else {
            sZip = Double.parseDouble(startZip.getText().toString());

        }

        String checkUserInput2 =  endZip.getText().toString();
        if (TextUtils.isEmpty(checkUserInput2)) {
            endZip.setError("You must enter a valid zip code!");
        }
        else {
            eZip = Double.parseDouble(endZip.getText().toString());
        }

    }