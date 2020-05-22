class AddFriendActivity extends AppCompatActivity implements IdCallback{
private AddFriendViewModel addFriendViewModel;

@Override
protected void onCreate(Bundle savedInstanceState) {
    .
    .
    .
    addFriendViewModel = ViewModelProviders.of(this).get(AddFriendViewModel.class);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addFriend();
        }
    });

}

private void addFriend() {
    .
    .
    .
    addFriendViewModel.addFriend(new FriendEntity(...),this);//<-- pass this
    finish();
}

 public void onFriendInserted(Long id){
  // do something with id
 } 
...

}