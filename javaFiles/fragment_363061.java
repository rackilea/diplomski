public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch(position){
            case 0 : return ReceivedFragment;
            case 1 : return ConnectionsFragment;
            case 2 : return SentFragment;
        }
        return null;