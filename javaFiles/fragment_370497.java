import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

private EditText userName;
private EditText userStreetAddress;
private EditText userCity;
private EditText userState;
private EditText userZip;
private EditText userPhone;
private EditText userEmail;
private EditText userDOB;

private SharedPreferences prefs;

private boolean hasDataBeenSaved;

private Set<String> set;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    prefs=this.getSharedPreferences("settings", Context.MODE_PRIVATE);
    set = prefs.getStringSet("Personal Information", null);
    if(set.size() > 0){
        hasDataBeenSaved = true;
    }

    if(hasDataBeenSaved){
        // display the store personal information

    }

    userName = (EditText)findViewById(R.id.nameRegistration);
    userStreetAddress = (EditText)findViewById(R.id.userStreetAddressRegistration);
    userCity = (EditText)findViewById(R.id.userCityRegistration);
    userState = (EditText)findViewById(R.id.userStateRegistration);
    userZip = (EditText)findViewById(R.id.userZipRegistration);
    userPhone = (EditText)findViewById(R.id.userPhoneRegistration);
    userEmail = (EditText)findViewById(R.id.userEmailRegistration);
    userDOB = (EditText)findViewById(R.id.userDOB);


    Button submitButton = (Button)findViewById(R.id.submit_button);
    submitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(!hasDataBeenSaved){
                // Data has not been save then save them

                String name = userName.getText().toString();
                String address = userStreetAddress.getText().toString();
                String city = userCity.getText().toString();
                String state = userState.getText().toString();
                String zip = userZip.getText().toString();
                String phone = userPhone.getText().toString();
                String email = userEmail.getText().toString();
                String dob = userDOB.getText().toString();

                if(!isEmpty(name) || !isEmpty(address) || !isEmpty(city) || !isEmpty(state) || !isEmpty(zip) || !isEmpty(phone) || !isEmpty(email) || !isEmpty(dob)){
                    Toast.makeText(MainActivity.this, "All input field must be filled", Toast.LENGTH_LONG).show();
                    return;
                }

                Set<String> set = new HashSet<String>();
                set.add(name);
                set.add(address);
                set.add(city);
                set.add(state);
                set.add(zip);
                set.add(phone);
                set.add(email);
                set.add(dob);

                SharedPreferences.Editor edit = prefs.edit();
                edit.putStringSet("Personal Information", set);
                edit.commit();
            }
        }
    });
}

private boolean isEmpty(String input){
    if(input.equals("")){
        return true;
    }
    return false;
}
}