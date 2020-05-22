@Override
public void onTabSelected(ActionBar.Tab tab, FragmentTransaction arg1) {
// TODO Auto-generated method stub
viewPager.setCurrentItem(tab.getPosition());
if(tab.getPosition()==1)//Replace 1 with your tab position
pen.setVisible(true);
}