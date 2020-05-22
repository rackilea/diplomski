protected void setupViewPager() {

    List<Fragment> fragments = new Vector<Fragment>();

    AFTab1 tab1 = (AFTab1) Fragment.instantiate(this, AFTab1.class.getName());
    AFTab2 tab2 = (AFTab2) Fragment.instantiate(this, AFTab2.class.getName());
    AFTab3 tab3 = (AFTab3) Fragment.instantiate(this, AFTab3.class.getName());

    fragments.add(tab1);
    fragments.add(tab2);
    fragments.add(tab3);

    tab1.aMethod();

    ...