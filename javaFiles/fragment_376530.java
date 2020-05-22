protected List<TableInfo> getTabList() {
    final List<TableInfo> tabList = new ArrayList<TableInfo>();
    for (int i=0; dataModel.getDataList().size(); i++) {
            Report rep = (Report) dataModel.getDataList.get(i);
            TableInfo tabInfo = new TableInfo();
            tabInfo.setId(rep.getId());
            tabInfo.setName(rep.getName());
            tabList.add(tabInfo);
    }
    return tabList;
}