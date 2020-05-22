@Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putString("date", date);
                bundle.putInt("position", position);
                fragmentFirst = new FirstFragment(); //modified
                return fragmentFirst; //added
            case 1:
                return new SecondFragment();
        }
        return null;
    }