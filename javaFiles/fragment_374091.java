//getting the number axes from the plot

NumberAxis D = (NumberAxis) plotAD.getDomainAxis();
NumberAxis R = (NumberAxis) plotAD.getRangeAxis();

//creating custom tick units based on lower and upper bound

Double DT = (D.getUpperBound() - D.getLowerBound())/5;
DecimalFormat DF = new DecimalFormat("#.#");
DF.setRoundingMode(RoundingMode.FLOOR);
String DTS = DF.format(DT);
DT = Double.parseDouble(DTS);
D.setTickUnit(new NumberTickUnit(DT));
Double RT = (R.getUpperBound() - R.getLowerBound())/5;
String RTS = DF.format(RT);
RT = Double.parseDouble(RTS);
R.setTickUnit(new NumberTickUnit(RT));