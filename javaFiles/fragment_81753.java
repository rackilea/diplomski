public class A_PagerAdapter extends FragmentPagerAdapter {
...
  private final static int NUM_PAGES = 6;
  private final Fragment[] listFragment = new Fragment[NUM_PAGES];
...
  public int getCount() {
    return NUM_PAGES;
  }
...
  public Fragment getItem(int index) {
   Fragment itemFragment = null;
   if (listFragment[index] == null) {
    // Hard-coded class factory.. yuck.
    switch(index) {
      case 0:
       itemFragment = new Fg_1();
       break;
      case 1:
       itemFragment = new Fg_2();
       break;
      case 2:
       itemFragment = new Fg_3();
       break;
      case 3:
       itemFragment = new Fg_4();
       break;
      case 4:
       itemFragment = new Fg_5();
       break;
      case 5:
       itemFragment = new Fg_6();
       break;
    }
    // Save this instance in case it is asked for again later..
    listFragment[index] = itemFragment;
   } else {
     // get the fragment we created earlier to avoid re-initializing
     itemFragment = listFragment[index];
   }
  return itemFragment;
 }
 ...