public void onSectionAttached(int number) {
        ArrayList<String> menuItems = new ArrayList<String>();
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                menuItems.add(mTitle.toString());
                mNavigationDrawerFragment.updateArray(menuItems);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                menuItems.add(mTitle.toString());
                mNavigationDrawerFragment.updateArray(menuItems);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                menuItems.add(mTitle.toString());
                mNavigationDrawerFragment.updateArray(menuItems);
                break;
        }
    }