List<ExportBean> exportBeans = new ArrayList<ExportBean>();
ExportBean exportBean = new ExportBean();
exportBean.setBooleanValue(true);
exportBean.setKeyValue("PRE_APPROVED_OFFER");
exportBean.setStringValue("111");

exportBeans.add(exportBean); // add object to list

exportBean.setBooleanValue(true);
exportBean.setKeyValue("PRE_APPROVED_OFFER1");
exportBean.setStringValue("222");

exportBeans.add(exportBean); // this time, the same reference is "added". This does not result in an addition (in fact, "add" will return false here

getLopRefNo(exportBeans);