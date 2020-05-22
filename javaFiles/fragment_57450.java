protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.full_img);
    final int imgResource = getIntent().getIntExtra(Menu.EXTRA_PICTURE, 0);
    final ImageView img = (ImageView)findViewById(R.id.img);
    img.setImageResource(imgResource);
}