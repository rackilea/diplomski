public class ExampleActivty extends AppCompatActivity implements ExampleTask.Listener {

    private ImageView mImageView;

    ...

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...

        new ExampleTask(this).execute();
    }

    @Override
    public void onResult(Bitmap image) {
        mImageView.setImageBitmap(image);
    }
}