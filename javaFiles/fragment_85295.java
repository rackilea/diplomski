ImageView imageView;

public void onCreate(Bundle b){
    super.savedInstanceState(b);
    setContentView(originalLayout);
    //Instatiate all of your original Views.
    imageView = (ImageView) R.id.yourImageView;
}


public void onButtonClick(View){
    setContentView(newLayout);
    imageView = (ImageView) R.id.yourNewImageView;
    //All other views
}