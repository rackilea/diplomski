public class ExampleActivty extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        final Thread thread = new Thread() {

            @Override
            public void run() {
                ...
                final Bitmap image = doStuff();
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(image);
                    }
                });
            }
        };
        thread.start();
    }
}