String[] grade =  new String[3];
  grade[0] = "";
  grade[1] = "Status A";
  grade[2] = "Status B";
  SymbolAxis rangeAxis = new SymbolAxis("", grade);
  rangeAxis.setTickUnit(new NumberTickUnit(1));
  rangeAxis.setRange(0,3);
  plot.setRangeAxis(rangeAxis);