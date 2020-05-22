series = new LineGraphSeries < > (getDataPoint());
momoGraphView.addSeries(series);
series.resetData(getDataPoint()); //once remove this

private DataPoint[] getDataPoint() {
    myDBHelper.getWritableDatabase();
    ArrayList<String> Xval = mOrderDBHelper.getX_axis();
    ArrayList<String> Yval = mOrderDBHelper.getY_axis();

    if (Xval==null || Xval.size()==0)
      return new DataPoint[0];

    DataPoint[] values = new DataPoint[Xval.size()];

    for (int i = 0; i < Xval.size(); i++) {
      values[i] = new DataPoint(Double.parseDouble(Xval.get(i)), Double.parseDouble(Yval.get(i)));
    }
    return values;
}