public class CoverSheet extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        final int imgResource = getIntent().getIntExtra(Menu.EXTRA_PICTURE, 0);
        final ImageView img = (ImageView)findViewById(R.id.img);
        img.setImageResource(imgResource);
    }
}