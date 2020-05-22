@Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
        case R.id.one:
            mViewPager.setCurrentItem(1);
            break;

        default:
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }