ValueEventListener mListener;
DatabaseReference mDataRef;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    FrameLayout rootView = (FrameLayout)inflater.inflate(R.layout.fragment_tch_profile, container, false);

    mListener = mDataRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
             {
             //SOME CODES HERE
             }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Toast.makeText(getActivity(),"The read failed: " + databaseError.getCode(),Toast.LENGTH_SHORT).show();
        }
    });

    return rootView;
}


    @Override
    public void onDetach() {
        super.onDetach();
        if(mDataRef!=null && mListener!=null){
            mDataRef.removeEventListener(mListener);
        }
    }