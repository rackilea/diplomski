tab = tabs.newTabSpec("tab_Busquedas");
tab.setContent(new Intent().setClassName("com.grapp", "com.grapp.homes").putExtras(bundle));
tab.setIndicator(null,null);
tabs.addTab(tab);
//here you set the image with rounded corners over the tab.
tabs.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.mytab_roundedcorners);