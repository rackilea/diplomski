@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    fragmentNavigation(view);

}
boolean b;
public void fragmentNavigation(View view) {
    if (b) {
        Navigation.findNavController(view).navigate(R.id.nav_gallery);
    } 
}