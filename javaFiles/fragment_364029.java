public void setTheme(DTypeActivity dTypeActivity, MyTheme theme) {
    final EditText edit_text = (EditText) findViewById(R.id.editText1);
    final View main_view = (View) findViewById(R.id.mainview);
    main_view.setBackgroundDrawable(getResources().getDrawable(theme.background));
    edit_text.getBackground().setAlpha(theme.alpha);
    edit_text.setTextColor(getResources().getColor(theme.color));
}