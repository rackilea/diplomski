package com.example.baharat2; 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

public class MainActivity extends Activity {
private Button signin_btn ;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    signin_btn = (Button) findViewById(R.id.button1);

    signin_btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub      
            // Determine whether the current user is an anonymous user
            if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
                // If user is anonymous, send the user to LoginSignupActivity.class
                Intent intent = new Intent(MainActivity.this,LoginSignupActivity.class);
                startActivity(intent);
                finish();
            } else {
            // If current user is NOT anonymous user
            // Get current user data from Parse.com
            ParseUser currentUser = ParseUser.getCurrentUser();
            if (currentUser != null) {
                // Send logged in users to Welcome.class
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            } else {
                // Send user to LoginSignupActivity.class
                Intent intent =Intent(MainActivity.this,LoginSignupActivity.class);
                startActivity(intent);
                finish();
        }
      }
        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return super.onCreateOptionsMenu(menu);
 }
}