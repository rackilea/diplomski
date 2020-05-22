protected void onCreate(Bundle paramBundle)
{
    super.onCreate(paramBundle);
    SharedPreferences sharedPreferences = getSharedPreferences("myPref", 0);

    // get the last chosen sticker
    int sticker = sharedPreferences.getInt("chosenSticker", R.drawable.normal);  //the .normal is the default value in case the user didn't choose one.
    myView.setImageViewResource(R.id.imageview, sticker);  //now you can use it


    // store user's choice for example:
    View.OnClickListener local2 = new View.OnClickListener()
    {
        public void onClick(View paramAnonymousView)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("chosenSticker", R.drawable.belton);
            editor.apply();

            // your rest of your code here ...
        }
    }
}