@Override
public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction arg1) {
// TODO Auto-generated method stub
if(tab.getPosition()==1)//Replace 1 with your tab position
pen.setVisible(false);
}