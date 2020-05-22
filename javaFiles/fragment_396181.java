@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_profile, container, false);
    mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
    String current_uid = Objects.requireNonNull(mCurrentUser).getUid();

    mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);

    ValueEventListener valueEventListener = mUserDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        String name = dataSnapshot.child("name").getValue().toString();
        String image = dataSnapshot.child("image").getValue().toString();
        String status = dataSnapshot.child("status").getValue().toString();
        String thumb_image = dataSnapshot.child("thumb_image").getValue().toString();

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    // you are calling return view inside the Value Listner that why you are getting the error
    });
    return view;
}