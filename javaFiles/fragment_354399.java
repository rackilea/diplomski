NumberFormat format = NumberFormat.getNumberInstance();
format.setMaximumFractionDigits(2); // etc.
XYItemLabelGenerator generator =
    new StandardXYItemLabelGenerator("{0} {1} {2}", format, format);
renderer.setBaseItemLabelGenerator(generator);
renderer.setBaseItemLabelsVisible(true);