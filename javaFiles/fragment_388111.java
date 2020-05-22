@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v =inflater.inflate(R.layout.hotel_frag,container,false);

   mLinearLayout = (LinearLayout) v.findViewById(R.id.expandable);
    //mLinearLayout.setVisibility(View.GONE);
    mLinearLayoutHeader = (LinearLayout) v.findViewById(R.id.header);

    //Add onPreDrawListener
    mLinearLayout.getViewTreeObserver().addOnPreDrawListener(
            new ViewTreeObserver.OnPreDrawListener() {

                @Override
                public boolean onPreDraw() {
                    mLinearLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                    mLinearLayout.setVisibility(View.GONE);

                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    mLinearLayout.measure(widthSpec, heightSpec);

                    mAnimator = slideAnimator(0, mLinearLayout.getMeasuredHeight());
                    return true;
                }
            });


    mLinearLayoutHeader.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (mLinearLayout.getVisibility()==View.GONE){
                expand();
            }else{
                collapse();
            }
        }
    });

    return v;
}