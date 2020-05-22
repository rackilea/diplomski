List<ExportBean> exportBeans = new ArrayList<ExportBean>();
ExportBean exportBean = new ExportBean();
exportBean.setBooleanValue(true);
exportBean.setKeyValue("PRE_APPROVED_OFFER");
exportBean.setStringValue("111");

exportBeans.add(exportBean); // add object to list

exportBean = new ExportBean(); //create new instance of ExportBean
exportBean.setBooleanValue(true);
exportBean.setKeyValue("PRE_APPROVED_OFFER1");
exportBean.setStringValue("222");

exportBeans.add(exportBean); // this new instance will be correctly added

getLopRefNo(exportBeans);