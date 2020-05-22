@Override
public Fragment getItem(int position) {
    switch (position){

        case 0:
            TabFragment3 tab3 = new TabFragment3();
            return tab3;
        case 1:
            TabFragment2 tab2 = new TabFragment2();
            return tab2;
        case 2:
            TabFragment1 tab1 = new TabFragment1();
            return tab1;
        default:
            return null;

    }
}