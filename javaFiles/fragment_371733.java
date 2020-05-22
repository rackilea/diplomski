@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

    // Your set up/initialization

    recyclerView.setAdapter(yourAdapter);

    first.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull final Task<QuerySnapshot> task){
            // Update your adapter and notifyDataSetChanged when needed here
        }
    }
}