private PlaceAutocompleteFragment mSearchPAF;
@Override
public void onDestroyView() {
    super.onDestroyView();
    PlaceAutocompleteFragment f = (PlaceAutocompleteFragment) getFragmentManager()
                                     .findFragmentById(R.id.place_autocomplete_fragment);
    if (f != null) 
        getFragmentManager().beginTransaction().remove(f).commit();
}