protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_account);

    email = (TextView)findViewById(R.id.email_txt);
    mAuth = FirebaseAuth.getInstance();
    UserId = mAuth.getCurrentUser().getUid();
    passwordtxt = (TextView)findViewById(R.id.pass_txt);

    mFirestore = FirebaseFirestore.getInstance();
   mFirestore.collection("Hospitals").document(UserId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {
            String user_name = documentSnapshot.getString("email");
            String password  = documentSnapshot.getString("password");


            email.setText(user_name);
            passwordtxt.setText(password);
        }
    });    
}