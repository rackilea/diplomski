@Override
public Fragment getItem(int position) {
    //returning the current tabs
    switch (position){
        case 0:
            Tab1 tab1 = new Tab1();
            return tab1;
        case 1:
            Tab2 tab2 = new Tab2();
            return tab2;
        case 3:
            Tab3 tab3 = new Tab3();
            return tab3;
        default:
            return null;
    }
}