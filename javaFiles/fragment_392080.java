public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder>{

    private ArrayList<owner> ownerlist;
    private Context mContext;

    public customAdapter(Context c , ArrayList<owner> p) {
        this.mContext = c;
        this.ownerlist = new Arraylist<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int 
    viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.prospectowners,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        owner owner = ownerlist.get(position);

        holder.name.setText(owner.getName());
        holder.field.setText(owner.getFieldname());
        holder.mobile.setText(owner.getMobile());
        holder.address.setText(owner.getAddress());
        holder.cost.setText(owner.getCost());
    }

    @Override
    public int getItemCount() {
        return ownerlist.size();
    }

    public void addData(ArrayList<owner> newData){
        this.ownerlist.addAll(newData);
        notifyOnDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView field;
        public TextView mobile;
        public TextView address;
        public TextView cost;

       public MyViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.field =  itemView.findViewById(R.id.fieldName);
            this.mobile =  itemView.findViewById(R.id.mobileowner);
            this.address =  itemView.findViewById(R.id.address);
            this.cost =  itemView.findViewById(R.id.cost);
        }
    }
}

public class prospectowner_listview extends AppCompatActivity {

    RecyclerView list;
    ArrayList <com.example.android.e7gzlykora.owner> ownerlist = new ArrayList <>();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    owner owner;
    customAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prospectowner_listview);

        list = findViewById(R.id.list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        list.setLayoutManager(manager);
        list.setHasFixedSize(true);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new customAdapter(prospectowner_listview.this,ownerlist);
        list.setAdapter(adapter);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("owners");

        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    owner o = data.getValue(owner.class);
                    ownerlist.add(o);
                }
                adapter.addData(ownerlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }
}