NewStylistAdapter newStylistAdapter;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view= inflater.inflate(R.layout.stylist_fragment, container, false);

    bundle=getArguments();
    if(bundle!=null){
        bookingDetails=(BookingDetails)bundle.getParcelable("bookingDetails");
    }

    recyclerView =  view.findViewById(R.id.stylistRecycler);
    try{
        date=bookingDetails.getDate();
        startTime=bookingDetails.getStartTime();
        services=bookingDetails.getServices();
        servicesId=bookingDetails.getServicesId();
        stylistidArray=bookingDetails.getStylistId();
        durationList=bookingDetails.getDuration();
        price=bookingDetails.getPrice();
        endTimeList=bookingDetails.getEndTime();
    }catch (Exception e){
        e.printStackTrace();
    }

    loadData();

    return view;
}

private void loadData(){
   setupAdapter();
   for(int i=0;i<stylistidArray.size();i++){
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        db.collection("stylists").document(stylistidArray.get(i)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot=task.getResult();
                    if(documentSnapshot.exists()){
                        String stylistid=documentSnapshot.getId();
                        String firstName=documentSnapshot.getString("firstName");
                        String lastName=documentSnapshot.getString("lastName");
                        String imageUrl=documentSnapshot.getString("imageUrl");
                        StylistCollection stylistCollection=new StylistCollection(stylistid,firstName,lastName,imageUrl);
                        stylistDetailsList.add(stylistCollection);
                        newStylistAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}

private void setupAdapter(){
   stylistDetailsList = new ArrayList<>();
   newStylistAdapter = new NewStylistAdapter(stylistDetailsList);
   RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecorator(ContextCompat.getDrawable(getContext(), R.drawable.divider));
   recyclerView.addItemDecoration(dividerItemDecoration);
   recyclerView.setAdapter(newStylistAdapter);
   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
   recyclerView.setLayoutManager(layoutManager);
}