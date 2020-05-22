AdapterFragmentPager adapterFragmentPager = new AdapterFragmentPager(getChildFragmentManager(), tabLayout.getTabCount());
vpFontStyle.setAdapter(adapterFragmentPager);
tabLayout.setupWithViewPager(vpFontStyle);   

tabLayout.getTabAt(0).setText("Style");
tabLayout.getTabAt(1).setText("Family");
tabLayout.getTabAt(2).setText("Shadow");

tabLayout.getTabAt(0).setIcon(R.drawable.ic_font_size);
tabLayout.getTabAt(1).setIcon(R.drawable.ic_font_type);
tabLayout.getTabAt(2).setIcon(R.drawable.ic_shadow);