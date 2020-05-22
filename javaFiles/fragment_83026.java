public Fragment getItem(int position) {
    int cnt = -1;     
    for (int i = 0; i < 4; i++) {
        if (shouldShowFragment(i)) cnt++;
        if (cnt == position) {
            switch(i) {
                case 0 : return new Fragment_One();
                case 1 : return new Fragment_Two();
                case 2 : return new Fragment_Three();
                case 3 : return new Fragment_Four();
            }
        }
    }
    return null;
}