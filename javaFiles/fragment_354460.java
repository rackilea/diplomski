Class subLayout;
  SubLayout2Interface subInterface = null;
  try {
    subLayout = Class.forName([Full Package Name] + subLayoutTitle);
    subInterface = (SubLayout2Interface) subLayout.newInstance();
  } catch (Exception e) {
    e.printStackTrace();
}

subInterface.setRootController(this);