public class NewBabyProfile extends Activity {

String GENDER = "Baby1Gender"; 

//Global declaration.
SharedPreferences babyOneGender;
SharedPreferences.Editor editor;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_baby_profile);

    //Initializations inside onCreate() so no error.

    babyOneGender = getSharedPreferences(getString(R.string.baby_one_profile), Context.MODE_PRIVATE);
    editor = babyOneGender.edit();


}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.new_baby_profile, menu);
    return true;
}

public void onRadioButtonClicked(View genderSelection){
    boolean checked = ((RadioButton) genderSelection).isChecked();

    switch(genderSelection.getId()) {
        case R.id.gender_boy:
            if (checked)
                editor.putString("gender","boy").commit();
            break;

        case R.id.gender_girl:
            if (checked)
                editor.putString("gender","girl").commit();
            break;

    }
}

}