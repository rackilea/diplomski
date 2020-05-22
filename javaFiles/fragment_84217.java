if(condition) {
  LocalizedTextUtil.clearDefaultResourceBundles();
  LocalizedTextUtil.addDefaultResourceBundle("ApplicationResources1");
  LocalizedTextUtil.setReloadBundles(true); 
}else {
  LocalizedTextUtil.clearDefaultResourceBundles();
  LocalizedTextUtil.addDefaultResourceBundle("ApplicationResources2");
  LocalizedTextUtil.setReloadBundles(true); 
}