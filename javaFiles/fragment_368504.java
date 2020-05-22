@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    final View rootView = inflater.inflate(R.layout.fragment_help, container, false);
    final Button goToContact = (Button) rootView.findViewById(R.id.btnGoToContact);

    goToContact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            HelpFragment HelpFragment = new HelpFragment();
            FragmentManager manager1 = getSupportFragmentManager();
            manager1.beginTransaction().replace(R.id.relativelayout_for_fragment,
                    HelpFragment,
                    HelpFragment.getTag()
            ).commit();
        }
    });

    return rootView;
}