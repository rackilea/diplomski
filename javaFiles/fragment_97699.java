public void onClick(View v) {
    FragmentManager fm = getFragmentManager();  
    FragmentBoxOffice f = (FragmentBoxOffice) fm.findFragmentByTag(FragmentBoxOffice.TAG);
    if (f == null) {
      f = new FragmentBoxOffice();
      fm.beginTransaction()
        .replace(R.id.fragment_container, f, FragmentBoxOffice.TAG)
        //.addToBackStack(null);  // uncomment this line if you want to be able to return to the prev. fragment with "back" button
        .commit();
    }
}