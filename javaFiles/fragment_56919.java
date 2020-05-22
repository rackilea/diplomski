@Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                tab1 tab1 = new tab1();
                return tab1;

            case 1:
                tab2 tab2 = new tab2();
                return tab2;
            case 3: // Should be 2
                tab3 tab3 =new tab3();
                return tab3;

            default: return null ;
        }