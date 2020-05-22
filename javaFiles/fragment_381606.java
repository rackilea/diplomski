public class PagerAdapter extends FragmentStatePagerAdapter {
int mNumOfTabs;
TabFragment2015 tab1;
TabFragmentXchanges tab2;
TabFragmentToday tab3;
TabFragment2016 tab4;
public PagerAdapter(FragmentManager fm, int NumOfTabs) {
    super(fm);
    this.mNumOfTabs = NumOfTabs;
}

@Override
public Fragment getItem(int position) {

    switch (position) {
        case 0:
            tab1 = new TabFragment2015();
            return tab1;
        case 1:
             tab2 = new TabFragmentXchanges();
            return tab2;
        case 2:
             tab3 = new TabFragmentToday();
            return tab3;
        case 3:
             tab4=new TabFragment2016();
            return tab4;
        default:
            return null;
    }
}

public void refreshFragment(int position) {
    switch (position) {
            case 1:
            tab1.refreshApi();
            break;
        case 2:
            tab2.refreshApi();
            break;
        case 3:
            tab3.refreshApi();
            break;
        case 4:
            tab4.refreshApi();
            break;
    }
  }

@Override
public int getCount() {
    return mNumOfTabs;
}}