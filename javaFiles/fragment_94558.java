public class Utilities {

   public void initialize(View mainHolder){
      ImageView imageView = mainHolder.findViewById(R.id.main_image);
      imageView.setImageResource(R.drawable.image3);
   }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   LayoutInflater inflater = LayoutInflater.from(this);
   View contentView = infler.inflate(R.layout.activity_android_server, null);
   setContentView(contentView);
   this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

   Utilities utilities = new Utilities();
   utilities.initialize(contentView);
}