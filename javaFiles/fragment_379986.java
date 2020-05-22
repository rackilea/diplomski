@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recommendations);

    productTwo = (TextView) findViewById(R.id.recommendations_product2);

    List<String> productList = new ArrayList<String>(); 
    list.add("traveling"); 
    list.add("short"); 
    list.add("not much");

    List<String> answerList = new ArrayList<String>();
    mRef = FirebaseDatabase.getInstance().getReference().child("BTSpeakers");
    mRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if(dataSnapshot.exists())
            {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                String answer = ds.child("answer").getValue().toString();
                answerList.add(answer);
                if(productList.equals(answerList)){
                    productTwo.setText("Speakers");
                }

              }
           }
       }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }