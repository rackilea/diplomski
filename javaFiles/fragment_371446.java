tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
              @Override 
              public void onTabChanged(String tabId) {
                int tab = tabHost.getCurrentTab();
                tabHost.getTabWidget().getChildAt(tab).setBackgroundColor(Color.parseColor("#FFFFFF"));
                setTabColor(tabHost);
              } 
            });        
    } 

    public static void setTabColor(TabHost tabhost) {
        for(int i=0;i<tabhost.getTabWidget().getChildCount();i++)
        { 
            tabhost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE); //unselected
        } 
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFFFFF")); // selected
}