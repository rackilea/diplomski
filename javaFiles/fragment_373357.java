SharedPreferences pref = getSharedPreferences("Theme", MODE_PRIVATE);
value= pref.getInt("yourTheme", 1);//1 is default value

if(value==2) {
    if (isDarkTheme) {
        appbackground.setVisibility(View.GONE);
        shade.setVisibility(View.GONE);
    } else {
        appbackground.setVisibility(View.VISIBLE);
        shade.setVisibility(View.VISIBLE);
    }
}else if(value==1){
        appbackground.setVisibility(View.GONE);
        shade.setVisibility(View.GONE);
}