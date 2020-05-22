public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Hydration();
            case 1:
                return new Info();
            case 2:
                return new Tips();
            default:
                // this should never happen
                return null;
            //return new Fragment();
        }
    }