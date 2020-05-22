public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

@Override
protected void onResume() {
    super.onResume();
    SharedPreferences sharedPreference = getSharedPreferences("switch", MODE_PRIVATE);
    boolean isChecked = sharedPreference.getBoolean("status",false);
    if (isChecked){
        Toast.makeText(this, "Enabled", Toast.LENGTH_SHORT).show();
    }else {
        Toast.makeText(this, "Disabled", Toast.LENGTH_SHORT).show();
    }

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu, menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
    case R.id.action_setting:
        Intent settingIntent = new Intent(getApplicationContext(), 
               Main2Activity.class);
        startActivity(settingIntent);
        return true;
    }
    return super.onOptionsItemSelected(item);
 }
}