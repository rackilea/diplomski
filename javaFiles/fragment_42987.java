public class MainActivity extends Activity
    {
        GridView grid;
        String[] names =
        {
            "String1",
            "String2",
            "String3",
            "String4",
            "String5",
            "String6",
            "String8",
            "String9",
            "String10"
        } ;
        int[] imageId =
        {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
        };

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            CustomGrid adapter = new CustomGrid(MainActivity.this, names, imageId);
            grid=(GridView)findViewById(R.id.grid);
            grid.setAdapter(adapter);
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id)
                {
                    Toast.makeText(MainActivity.this, "You Clicked at " +names[+ position], Toast.LENGTH_SHORT).show();

                }
            });    
        }
    }