public void addYourFragment(){
                YourFragment myFragment = new YourFragment();
                FragmentManager fragmentManager = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, myFragment, tagToUniqlyIdentifiedFramgent);
                fragmentTransaction.addToBackStack(tagToUniqlyIdentifiedFramgent);
                fragmentTransaction.commit();                       
}




@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();

    Intent nextIntent;
    switch (id){
        case R.id.item1:
            addYourFragment();
            break;
        case R.id.item2:           
            addYourFragmentTwo()
            break;
        case R.id.item3:
            addYourFragmentThree()
            break;
    }

    drawer.closeDrawer(GravityCompat.START);
    return true;
}