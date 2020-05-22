barChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
                                              @Override
                                              public String getFormattedValue(float value, AxisBase axis) {
                                                  return "value ★";
                                              }
                                          }