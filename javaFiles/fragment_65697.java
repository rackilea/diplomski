imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(this,PhotoViewerActivity.class);
intent.putExtra("image", imageurl);
    startActivity(intent);
            }
        });



public class PhotoViewerActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 


        String url = getIntent().getStringExtra("image");
     // you can show image from url using library like glide or picasso
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_photo_viewer;
    }

    @Override
    public void onBackPressed() {
        PhotoViewerActivity.this.finish();
    }
}