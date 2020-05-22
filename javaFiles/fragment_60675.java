final CheckBox foodCheckBox = (CheckBox)findViewById(R.id.item_food_check_box);
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    final SharedPreferences.Editor editor = preferences.edit();

    foodCheckBox.setChecked(prefs.getBoolean("checked",false));

foodCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { 
    @Override 
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
         isCheckedValue = isChecked;
        editor.putBoolean("checked", isChecked);
        editor.apply();
        }
    });