public class RemoveTagActivity extends Activity implements View.OnClickListener {

    final String TAG = "testingProject";

    Button add;
    EditText interest;
    String stuff;
    ImageView imgFavorite;
    int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_tag);

        interest = (EditText) findViewById(R.id.interest);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);
    }

    @SuppressWarnings("ResourceType")
    public void onClick(View v) {
        if (v == add) {

            // Read the edit text
            stuff = interest.getText().toString();

            // Inflate the tag layout
            LayoutInflater layoutInflater = getLayoutInflater();
            final ViewGroup root = (ViewGroup) findViewById(android.R.id.content);


            final View tagView = layoutInflater.inflate(R.layout.tag_layout, root, false);
            root.addView(tagView);

            // Get access to the subviews of Tag View
            final TextView tagTextView = (TextView) tagView.findViewById(R.id.tagTextView);
            imgFavorite = (ImageView) tagView.findViewById(R.id.imageView);

            // Set their id's to 1
            imgFavorite.setId(id);
            tagTextView.setId(id);

            tagTextView.setText(stuff);

            imgFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Remove the Tag Layout
                    ((ViewGroup) tagView.getParent()).removeView(tagView);
                }
            });

            Log.i(TAG, "first id given" + id);

            id = id + 1;

            Log.i(TAG, "this id is" + id);


        }
    }
}