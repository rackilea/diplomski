tabHost.setOnTabChangedListener(new OnTabChangeListener() {

        public void onTabChanged(String arg0) {
            for (int i = 0; i < tab.getTabWidget().getChildCount(); i++) {
                tab.getTabWidget().getChildAt(i)
                        .setBackgroundResource(R.drawable.tab_selected); // unselected
            }
            tab.getTabWidget().getChildAt(tab.getCurrentTab())
                    .setBackgroundResource(R.drawable.tab_unselected); // selected

        }
    });