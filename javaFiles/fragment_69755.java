public class ViewCart extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseUser currentUser;
    ArrayList<Cart> CartList;
    RecyclerView recyclerView;

    private int totalPrice = 0;
    TextView total;


    private String userID, cust_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        total = findViewById(R.id.total);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();

        if (currentUser != null) {
            userID = currentUser.getUid();
            cust_id = firebaseAuth.getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference("Cart").child(cust_id);
            recyclerView = findViewById(R.id.rv);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    CartList = new ArrayList<>();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        CartList.add(ds.getValue(Cart.class));
                        Cart cart = ds.getValue(Cart.class);
                        totalPrice = totalPrice + (int)Double.parseDouble(cart.getPrice()) *  Integer.valueOf(cart.getQuantity());

                    }

                    CartAdapter cartAdapter = new CartAdapter(CartList);
                    recyclerView.setAdapter(cartAdapter);
                    total.setText( String.valueOf(totalPrice));

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else
            openDialog();

    }

    private void openDialog() {

        LoginDialog loginlDialog = new LoginDialog();
        loginlDialog.show(getSupportFragmentManager(), "login dialog");

    }