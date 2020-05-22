public class CommentsActivity extends FragmentActivity {
...
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_comments);
    if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.id_layout_comments, new CommentsFragment())
                .commit();
    }
...
}