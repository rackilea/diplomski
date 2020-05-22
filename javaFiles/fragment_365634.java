public class AllUserPartiesListActivity extends AppCompatActivity {
    private static final String TAG = "AllUserPartiesListActivity";

    private RecyclerView UserPartiesList;
    private DatabaseReference UsersRef, AllUserPartiesRef;
    private FirebaseAuth mAuth;
    private String currentUserID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_all_horizontal_parties);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();

        // *** You may call your variable AllUserPartiesRef yet you don't target all user parties,
        // *** just one user's parties. This could be renamed to currentUserParties.
        AllUserPartiesRef = FirebaseDatabase.getInstance().getReference().child("all_user_parties").child(currentUserID);;

        //The next code is working on displaying all users posts
        UserPartiesList = (RecyclerView) findViewById(R.id.horizontalRecycleView);
        UserPartiesList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllUserPartiesListActivity.this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        UserPartiesList.setLayoutManager(linearLayoutManager);

        DisplayAllUsersData();
    }


    private void DisplayAllUsersData() {

        AllUserPartiesRef.addReValueEventListener(new ValueEventListener(){
          @Override
          public void onDataChange(DataSnapshot snapshot){
            List<String> posts = new ArrayList<>();
            for (DataSnapshot nameSnapshot : snapshot.getChildren()) {
              String name = nameSnapshot.getValue(String.class);
              String date = nameSnapshot.getKey();
              String post = date + " " + name;
              posts.add(post); 
            }

            // *** Reaching this point posts list includes your previously fetched
            // *** data in "date name" format, time to bind this data to the Adapter.
            PostsAdapter adapter = new PostsAdapter(AllUserPartiesListActivity.this);
            UserPartiesList.setAdapter(adapter);

            // *** Adapter created, bind the posts and call notify
            adapter.addPosts(posts);
            adapter.notifyDatasetChanged(); 
          }

          @Override
          public void onCancelled(DatabaseError error){}
        });
    }

    public static class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder>{

      private Context context;
      //  This is your fetched data in a form of date+name String
      //  since you have only one textview to display this pair.
      private List<String> posts; 

      public PostsAdapter(Context context) {
          this.context = context;
      }

      public void addPosts(List<String> posts) {
          this.posts = posts;
      }

      @NonNull
      @Override
      public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          LayoutInflater inflater = LayoutInflater.from(context);
          View itemView = inflater.inflate(R.layout.layout_horizontal_list_item, viewGroup, false);
          return new PostsViewHolder(itemView);
      }

      @Override
      public void onBindViewHolder(@NonNull PostsViewHolder postsViewHolder, int position) {
          if (posts != null && posts.size() > 0) {
              postsViewHolder.bindPost(posts.get(position));
          }
      }

      @Override
      public int getItemCount() {
          if (posts != null && posts.size() > 0) {
              return posts.size();
          }
          return 0;
      }

      public static class PostsViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView textView;

    public PostsViewHolder(View itemView) {
          super(itemView);
          mView = itemView;
          textView = (TextView) mView.findViewById(R.id.name);
        }

        public void setCreateAccTime(String createTime) {
          TextView CreateTime = (TextView) mView.findViewById(R.id.name);
          CreateTime.setText(createTime);
        }

        public void setParty(String party) {
          ImageView UserPostParty = (ImageView) mView.findViewById(R.id.image_view);
          Picasso.get().load(party).fit().into(UserPostParty);
        }

        public bindPost(String post){
          textView.setText(post);
        }
      }
    }
}