@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,   
    Bundle savedInstanceState) {

  ((MyApp)getActivity().getApplication()).getImageComponent().inject(this);

}