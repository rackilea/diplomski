package sa.edu.qu.coc.cocapps.prefs;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import sa.edu.qu.coc.cocapps.R;

public class PreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar = null;
    private LinearLayout fontSize, appColor;
    public static final String PREFS_KEY = "preferences";
    private static int item = 0, color = 0;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        prefs = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
        switch(prefs.getInt("appColor", 0)) {
            case 0:
                activity.setTheme(R.style.AppTheme);
                break;

            case 1:
                activity.setTheme(R.style.BlackTheme);
                break;

            case 2:
                activity.setTheme(R.style.BlueTheme);
                break;

            case 3:
                activity.setTheme(R.style.GreenTheme);
                break;

            case 4:
                activity.setTheme(R.style.MagentaTheme);
                break;
        }
        setContentView(R.layout.activity_preferences);

        initViews();

        setSupportActionBar(toolbar);

        fontSize.setOnClickListener(this);
        appColor.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fontSize = (LinearLayout) findViewById(R.id.fontSize);
        appColor = (LinearLayout) findViewById(R.id.appColor);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fontSize:
                AlertDialog.Builder changeFontSizeDialog = new AlertDialog.Builder(this)
                        .setTitle("Select Size")
                        .setIcon(android.R.drawable.sym_action_chat)
                        .setSingleChoiceItems(R.array.font_sizes, item, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                editor = prefs.edit();
                                editor.putInt("fontSize", i);
                                editor.commit();

                                item = i;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // DO not do anything.
                            }
                        });
                changeFontSizeDialog.show();
                break;

            case R.id.appColor:
                AlertDialog.Builder changeAppColorDialog = new AlertDialog.Builder(this)
                        .setTitle("Select Color")
                        .setIcon(android.R.drawable.sym_action_chat)
                        .setSingleChoiceItems(R.array.app_colors, color, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                editor = prefs.edit();
                                editor.putInt("appColor", i);
                                editor.commit();

                                color = i;

                                activity.finish();
                                activity.startActivity(new Intent(activity, activity.getClass()));
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // DO not do anything.
                            }
                        });
                changeAppColorDialog.show();
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}