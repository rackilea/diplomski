public static class MyAdapter extends FragmentStatePagerAdapter {
  ArrayList<Fragment> fragmentArray = new ArrayList<Fragment();
   public MyAdapter(FragmentManager fm) {
       super(fm);
   }

   //didn't put in the function to populate the list with fragments

  public void replaceItem(Fragment newFrag, int pos){
       fragmentArray.remove(pos);
       fragmentArray.add(pos,newFrag);
       notifyDataSetChanged();
  }


  @Override
   public int getCount() {
       return fragmentArray.size();
   }

   @Override
   public Fragment getItem(int position) {
       return fragmentArray.get(position);
   }