public void onDestroyView() 
 {
    super.onDestroyView(); 
    Fragment fragment = (getSupportFragmentManager().findFragmentById(R.id.map));  
    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
    ft.remove(fragment);
    ft.commit();
}