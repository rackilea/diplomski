public class MainActivity extends AppCompatActivity {

    CommentsDataSource cds = new CommentsDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cds.open();
        cds.createComment("A",10.55f);
        cds.createComment("B",20.55f);
        cds.createComment("C",30.55f);

        List<Comment> comments = cds.getAllComments();
        for (Comment c: comments) {
            Log.d("COMMENTINFO","ID=" + c.getId() + " NAME = " + c.getName() + " PRICE = " + c.getItemPrice() );
        }
    }
}