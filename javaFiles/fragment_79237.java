Report report = reports.get(col - 1); //made those names up but you should get the idea
switch (row) {
  ...
  case 5:
    double p = report.getPercentage(); //assuming 10% is stored as 0.1
    return String.format("%.0f%%", p * 100); //%.0f means a floating point number with 0 fraction digits
  ...
}