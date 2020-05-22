package br.liveo.ndrawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

import br.liveo.navigationliveo.NavigationLiveo;

public class Profile extends ActionBarActivity {

    private RelativeLayout editLayout;
    private SharedPreferences preferences;
    private boolean edit = false;
    private ImageView profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        editLayout = (RelativeLayout) findViewById(R.id.profile_edit);
        editLayout.setVisibility(View.INVISIBLE);

        preferences = getApplicationContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        String userName = preferences.getString("userName", "No User");
        String userEmail = preferences.getString("userEmail", getString(R.string.samplemail));
        String userPhoto = preferences.getString("userPhoto", "NULL");
        String userAbout = preferences.getString("userAbout", getResources().getString(R.string.about));

        TextView name = (TextView) findViewById(R.id.userName);
        name.setText(userName);

        TextView email = (TextView) findViewById(R.id.mail);
        email.setText(userEmail);

        TextView about = (TextView) findViewById(R.id.about);
        about.setText(userAbout);

        profilePic = (ImageView) findViewById(R.id.userPhoto);
        if (userPhoto.equals("NULL")) {
            profilePic.setBackgroundResource(R.drawable.ic_no_user);
        } else {
            //Bitmap bitmap = Profile.decodeBase64(userPhoto);
            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(userPhoto));
            } catch (IOException e) {
                profilePic.setBackgroundResource(R.drawable.ic_no_user);
                return;
            }
            profilePic.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile_edit:
                if (edit) {
                    saveProfile();
                    edit = false;
                    finish();
                } else {
                    item.setIcon(R.drawable.ic_action_accept);
                    edit = true;
                    profileEdit();
                }
                return true;
            default:
                finish();
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveProfile() {
        TextView name = (TextView) findViewById(R.id.edit_name);
        TextView mail = (TextView) findViewById(R.id.edit_mail);
        TextView about = (TextView) findViewById(R.id.edit_about);

        SharedPreferences.Editor editor = preferences.edit();

        if (name.getText().toString().length() > 0)
            editor.putString("userName", name.getText().toString());
        if (mail.getText().toString().length() > 0)
            editor.putString("userEmail", mail.getText().toString());
        if (about.getText().toString().length() > 0)
            editor.putString("userAbout", about.getText().toString());

        editor.apply();
    }

    private void profileEdit() {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.profile_display);
        layout.setVisibility(View.INVISIBLE);
        editLayout.setVisibility(View.VISIBLE);
    }

    public void pickUser(View view) {
        Intent intent;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        } else {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        }

        intent.setType("image/*");
        startActivityForResult(intent, 3645);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultData) {

        if (requestCode == 3645 && resultCode == NavigationLiveo.RESULT_OK && resultData != null) {

            Uri selectedImage = resultData.getData();
            profilePic.setImageURI(selectedImage);
            SharedPreferences preferences = getSharedPreferences("User", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("userPhoto", selectedImage.toString());
            editor.apply();
        }
    }
}