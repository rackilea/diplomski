int value = 1;
for(int i = 0; i < imgbtn.length; i++){
    int resId = getResources().getIdentifier("imgButton" + value, "id", this.getPackageName());
    imgbtn[0] = (ImageButton) findViewById(resId);
    value++;
}