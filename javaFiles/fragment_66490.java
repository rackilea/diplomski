@Override
public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
    View view = MyViewFactory.createConstraintLayoutWithButton(getContext)

    view.findViewById(R.id.emailSignInButton).setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

        }
    });

    return view;
}