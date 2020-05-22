class FragmentA extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Button button = new Button(getActivity());
        button.setText("Replace");
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentB fragmentB = new FragmentB();
                transaction.replace(R.id.container_id, fragmentB);
                transaction.commit();
            }
        });
        return button;
    }
}