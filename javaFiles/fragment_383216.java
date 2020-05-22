public class DealRawDataActivity extends AppCompatActivity {
    DatabaseReference databaseDrinks;
    String keys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_raw_data);
        databaseDrinks = FirebaseDatabase.getInstance().getReference("drinks").child("-LWLuM2nesg0uaP0dLSn");
        databaseDrinks.orderByChild("drinkManufacturerID").equalTo("D1eY5v9guwSIWMvfLoq8xGywrT53").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot datas : dataSnapshot.getChildren()) {
                    keys = datas.getKey();
                }
                Toast.makeText(this, keys, Toast.LENGTH_LONG).show(); //Should work!!
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}