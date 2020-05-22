public class Complaint extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mComplaintsDatabaseRegerence;
    private EditText ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mComplaintsDatabaseRegerence=mFirebaseDatabase.getReference().child("Complaints");
        ct=findViewById(R.id.comp_box); // It needs to be below your setContentView.
    }
}