private ArrayList<Winkel> mijnwinkels;
private Adaptor mAdaptor;

onCreateView() { 
    //... Other code 
    mijnwinkels = new  ArrayList<Winkel>();
    // mRecyclerView =... 
    mAdaptor = new Adaptor(mijnwinkels, this.getActivity());
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    mRecyclerView.addItemDecoration(new VerticalSpace(30));
    mRecyclerView.setAdapter(adaptor);
    adaptor.setItemCLickCallback(this);
   // etc... 
} 

@Override
public void onSuccess(ArrayList<Winkel> winkels) {
    mijnwinkels.clear();
    mijnwinkels.addAll(winkels);
    mAdaptor.notifyDatasetChanged(); // something like this... Not sure how RecyclerView does it 
 }