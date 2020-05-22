private CollapsingToolbarLayout collapsingToolbarLayout;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    collapsingToolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
    AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.appBar);

    return view;
}

public void setTitle(String passedTitle){
    collapsingToolbarLayout.setTitle(passedTitle);
}