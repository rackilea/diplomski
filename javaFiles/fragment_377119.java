protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);

            sharedPreferences = getApplicationContext.getSharedPreferences("my_Pref", MODE_PRIVATE);

             if(sharedPreferences != null)
            {

            sbAge.setProgress(sharedPreferences.getInt(AGE_SCORE, 0));
            spMyStatus.setSelection(sharedPreferences.getInt(STATUS_SCORE, 0));
            if(sharedPreferences.getInt(SEX_SCORE, 0) == 1)
                rbMaleMe.isChecked();
            else if (sharedPreferences.getInt(SEX_SCORE, 0) == 2)
                rbFemaleMe.isChecked();
        }