private void addSelectedCardToGlobalUserBox(int position) {
        ImageAdapter imageAdapter = new ImageAdapter(getContext());

        UserBoxGLBFragment fragment = ((MainActivity)getActivity()).getMyFragment();

        if (fragment != null){
            fragment.addInteger(imageAdapter.getmThumbIds(0)); // pass the Drawable's Integer value to the fragmnet
        }

        Toast.makeText(getActivity(), "Selected icon: " + imageAdapter.getmThumbIds(position), Toast.LENGTH_SHORT).show();
    }