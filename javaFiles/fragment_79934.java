@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);

    Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    getSupportActionBar().setCustomView(R.layout.abs_layout_post);

    Post = findViewById(R.id.Post);

    close = findViewById(R.id.close);
    post = findViewById(R.id.post);
    storageReference = FirebaseStorage.getInstance().getReference("post");

    close.setOnClickListener(view -> startActivity(new Intent(PostActivity.this, BottomActivity.class)));
    // TODO remove this one
    finish();

    post.setOnClickListener(view -> uploadImage());


    video = findViewById(R.id.ImageButton);
    video.setOnClickListener(view -> {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GALLERY_REQUEST);

    });
}