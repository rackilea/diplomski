Resources res = getResources();
    TabHost tabHost = getTabHost();
    TabHost.TabSpec spec;
    Intent intent;

    intent = new Intent().setClass(this, CatalogActivity.class);
    String txtCatalog = (String) getText(R.string.catalog);
    spec = tabHost.newTabSpec("catalog").setIndicator(txtCatalog,
            res.getDrawable(R.drawable.ic_tab_catalog)).setContent(intent);
    tabHost.addTab(spec);