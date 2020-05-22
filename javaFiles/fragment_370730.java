public void onChangeTab(TabChangeEvent event){
    Tab activeTab = event.getTab();
    if(!activeTab.getTitle().endsWith("[Pressed]")){
        activeTab.setTitle(activeTab.getTitle() + " [Pressed]");            
    }
    System.out.println(activeTab.getTitle());
    counter = counter + 1;
    RequestContext.getCurrentInstance().update("panel");
}