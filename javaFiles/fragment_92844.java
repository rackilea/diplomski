GridFieldManager gfm = new GridFieldManager(1, 2, 0);
gfm.setColumnProperty(0, GridFieldManager.FIXED_SIZE, Display.getWidth()* 1/5);
gfm.setColumnProperty(1, GridFieldManager.PREFERRED_SIZE_WITH_MAXIMUM, Display.getWidth()* 4/5);

ScrollableEditField sef1 = new ScrollableEditField("", "", 32, EditField.FILTER_EMAIL);
sef1.setBorder(BorderFactory.createRoundedBorder(new XYEdges(1,1,1,1)));
gfm2.add(sef1);