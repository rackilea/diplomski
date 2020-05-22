public class RewardValueListener implements ValueEventListener {

    private FirebaseAuth mAuth;
    private Rewards mRewards;

    public RewardValueListener(Rewards rewards) {
        this.mRewards = rewards; 
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();
        Integer counter = dataSnapshot.child(userid).child("counter").getValue(Integer.class);

        if (counter == 1) {
            // mRewards.mstreaming.setBackground( ... );  
        } else if (counter == 2) {
            // mRewards.mcustom.setBackground( ... ); 
        }
    }