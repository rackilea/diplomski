ArrayList<String> fragArrayList = new ArrayList<>();

fragArrayList = intent.getStringArrayListExtra("fragArrayList");

Button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      setFragment(fragArrayList.get(i));
    }
});

 private void setFragment(String fragClass) {

    Fragment fragment = Fragment.instantiate(this, fragClass);

    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction()
            .replace(R.id.layout, fragment)
            .addToBackStack(null)
            .commit();
}