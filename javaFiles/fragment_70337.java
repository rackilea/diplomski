public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    ...
    if (savedInstanceState != null) {
        //Restore the fragment's state here
    }
}
...
@Override
public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

//Save the fragment's state here


}