sharedPreferences = this.getSharedPreferences("my_Pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
    edit.putInt(AGE_SCORE, sbAge.getProgress());
        edit.putInt(STATUS_SCORE, spMyStatus.getSelectedItemPosition());
        if (rbFemaleMe.isChecked())
            edit.putInt(SEX_SCORE, 1);
        else if(rbMaleMe.isChecked())
            edit.putInt(SEX_SCORE, 2);
        edit.commit();
    finish();