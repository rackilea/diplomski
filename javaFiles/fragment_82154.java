public void addFragment(String tabfragment) {
  try{
     Fragment fragment = (Fragment) Class.forName(fragmentPackage+ "." + tabfragment).newInstance();
     mFragmentList.add(fragment);
   } catch(ClassNotFoundException e) {
     e.printStackTrace();
  }       
}