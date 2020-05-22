public class TeamAOffense extends ActionBarActivity {
    Button buttonPandr, buttonSandc, buttonMandf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_aoffense);
        buttonPandr = (Button)findViewById(R.id.PandRA);
        buttonMandf = (Button)findViewById(R.id.MandFA);
        buttonSandc = (Button)findViewById(R.id.SandCA);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String pandr = pref.getString("PANDR", "0");
        String mandf= pref.getString("MANDF", "0");
        String sandc = pref.getString("SANDC", "0");
        if(pandr.equals("1")){
          buttonPandr.setEnabled(false);
        }

        if(mandf.equals("1")){
          buttonMandf.setEnabled(false);
        }

        if(sandc.equals("1")){
          buttonSandc.setEnabled(false);
        }

// code to enable the three buttons again, if all the buttons are disabled.
        if(mandf.equals("1") && panfr.equals("1") && sandc.equals("1")){
           buttonSandc.setEnabled(true);
           buttonSandc.setEnabled(true);
           buttonSandc.setEnabled(true);
           SharedPreferences.Editor editor = pref.edit();
           editor.putString("MANDF", "0");
           editor.putString("PANDR", "0");
           editor.putString("SANDC", "0");
           editor.apply();
        }

    }

    // Button for Pick and Roll, where sharedpreferences assigns offense for use in another activity.
    public void submitPANDR (View view) {
        Intent intent = new Intent(this, ExchangeAToB.class);
        startActivity(intent);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("offense", "Pick and Roll");
        editor.putString("PANDR", "1");
        editor.apply();
    }

    // Button for Move and Flow, where sharedpreferences assigns offense for use in another activity.
    public void submitMANDF (View v) {
        Intent intent = new Intent(this, ExchangeAToB.class);
        startActivity(intent);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("offense", "Move and Flow");
        editor.putString("MANDF", "1");
        editor.apply();
    }

    // Button for Set and Called, where sharedpreferences assigns offense for use in another activity.
    public void submitSANDC (View v) {
        Intent intent = new Intent(this, ExchangeAToB.class);
        startActivity(intent);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("offense", "Set and Called");
        editor.putString("SANDC", "1");
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_team_aoffense, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }