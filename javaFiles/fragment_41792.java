// Replace the fragment corresponding to the category
    private void replaceFragment(int position) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_category_container, this.categories.get(position));
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }