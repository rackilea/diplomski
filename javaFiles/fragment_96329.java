@Override
public Fragment getItem(int position) {
    switch (position){

        case 2://change it from 0 -> max
            TabFragment1 tab1 = new TabFragment1();
            return tab1;
        case 1:
            TabFragment2 tab2 = new TabFragment2();
            return tab2;
        case 0:
            TabFragment3 tab3 = new TabFragment3();
            return tab3;
        default:
            return null;

    }
}