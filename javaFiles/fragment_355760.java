public Fragment getFragmentByTitle(String title) {
    if (!mFragmentTitles.contains(title))
        return null;

    return mFragments.get(mFragmentTitles.indexOf(title));
}