@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_balance, container, false);
    ExpandableListView expandableListView = (ExpandableListView)view.findViewById(R.id.fragBalance_expListView);
    final ArrayList<Balance> arrayList;
    ArrayList<Balance> arrayList1 = null;
    try {
        arrayList1 = (ArrayList<Balance>) new BalanceController(new BalanceFromApiJson()).getBalance(getContext(),"http://10.113.10.10:50591/api/Balance?reservationID=4564548");
    } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
        //arrayList1 = null;
    }

    arrayList = arrayList1;
    if(arrayList1 != null){
        BalanceAdapter balanceAdapter = new BalanceAdapter(getContext(),arrayList);
        expandableListView.setAdapter(balanceAdapter);
    }



    expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            Toast.makeText(getContext(),arrayList.get(groupPosition).getTransactions().get(childPosition).toString() , Toast.LENGTH_SHORT).show();
            return false;
        }
    });


    return view;
}