public void gotoBasicControls(View view) {

viewPager.setCurrentItem(0, true);  
((ImageButton)view).setImageResource(R.drawable.remote_selected_icon_transparent);
buttonText.setTextColor(getResources().getColor(R.color.colorAppOrange));
}