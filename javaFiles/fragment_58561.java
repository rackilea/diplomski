public class MainActivity extends AppCompatActivity {
private NavigationView navigationView;
private DrawerLayout drawerLayout;
private RecyclerView postlist;
private Toolbar mToolbar;
private ActionBarDrawerToggle actionBarDrawerToggle;
private FirebaseAuth mAuth;
private FirebaseUser FirebaseUser;
private DatabaseReference  UsersRef;
private CircleImageView NavProfileImage;
private ImageButton AddNewPostButton;
private TextView NavProfileUserName;
String currentUserID;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mAuth = FirebaseAuth.getInstance();
    final FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
    if (mFirebaseUser != null) {
        currentUserID = mFirebaseUser.getUid();
    }




    mToolbar =(Toolbar) findViewById(R.id.main_page_toolbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setTitle("Home");

    drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
   actionBarDrawerToggle =  new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.drawer_open, R.string.drawer_close);
    navigationView = (NavigationView)findViewById(R.id.navigation_view);
   AddNewPostButton = (ImageButton)findViewById(R.id.add_new_post_button);

    drawerLayout.addDrawerListener(actionBarDrawerToggle);
   actionBarDrawerToggle.syncState();
   getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    View navView = navigationView.inflateHeaderView(R.layout.nav_header);
    NavProfileImage = (CircleImageView)navView.findViewById(R.id.nav_profile_image);
    NavProfileUserName = (TextView) navView.findViewById(R.id.nav_user_full_name);

    UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");
      // replace below code
     if (mFirebaseUser != null) {

    UsersRef.child(currentUserID).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot)
        {
            if(dataSnapshot.exists())
            {   if (dataSnapshot.hasChild("fullname")){
                String fullname = dataSnapshot.child("fullname").getValue().toString();
                NavProfileUserName.setText(fullname);
            }if (dataSnapshot.hasChild("profileimage")) {
                String image = dataSnapshot.child("profileimage").getValue().toString();
                Picasso.with(MainActivity.this).load(image).placeholder(R.drawable.profile).into(NavProfileImage);

            }else {
                Toast.makeText(MainActivity.this, "Profile name do not exists...", Toast.LENGTH_SHORT).show();
            }




            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

    }else{
     sendUserToLoginActivity();
    }

    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        { UserMenuSelector(item);

            return false;
        }
    });
    AddNewPostButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SendUserToPostActivity();

        }
    });
}

private void SendUserToPostActivity() {
    Intent addNewPostIntent = new Intent (MainActivity.this,PostActivity.class);
    startActivity(addNewPostIntent);
}

@Override
protected void onStart() {
    super.onStart();
    FirebaseUser currentUser = mAuth.getCurrentUser();
    if (currentUser == null)
    {
        sendUserToLoginActivity();
    }else{
        CheckUserExistance();
    }
}

private void CheckUserExistance()
{
    final String current_user_id = mAuth.getCurrentUser().getUid();
      UsersRef.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              if (!dataSnapshot.hasChild(current_user_id)){
                  sendUserToSetupActivity();
              }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });
}

private void sendUserToSetupActivity() {
    Intent setupIntent = new Intent(MainActivity.this, SetupActivity.class);
    setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(setupIntent);
    finish();

}

private void sendUserToLoginActivity()
{
    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
     loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
     startActivity(loginIntent);
     finish();

}