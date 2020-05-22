playlists.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //getActivity().getTabHost().setCurrentTabByTag("TAB2");
            //viewPager.setCurrentItem(2);
          mListener.onButtonClick(2);
        }
    });