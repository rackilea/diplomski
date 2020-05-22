public boolean setPagerViewContents(int mode, ArrayList<String> titles) {
        try {
            mAdapter = new TabPagerAdapter(getSupportFragmentManager(), titles.size(), mode);
            mViewPager.setAdapter(mAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
            return true;
        } catch (Exception e) {
            mErrorReporter.reportError(e);
            return false;
        }
    }