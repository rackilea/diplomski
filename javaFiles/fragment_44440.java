@Override
public Fragment getItem(int position) {

    switch (position) {
        case 0:
            FirstFragment tab1 = new FirstFragment();
            return tab1;
        case 1:
            SecondFragment tab2 = new SecondFragment();
            return tab2;
        default:
            return null;
    }
}