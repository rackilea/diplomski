@Override
    public void lectureSelected(String videoId, String lectureDescription) {
        //Can't get the passed details
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if(fragment instanceof FragmentClasas) {
                    fragment.lectureSelected(video,description);
                }
            }
        }
    }