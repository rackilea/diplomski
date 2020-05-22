public static RequisitionsFragment newInstance(String username) {
    RequisitionsFragment fragment = new RequisitionsFragment();
    Bundle args = new Bundle();
    args.putString("USERNAME", username);
    fragment.setArguments(args);
    return fragment;
}