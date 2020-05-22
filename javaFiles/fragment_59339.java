mChart2 = (LineChart)findViewById(R.id.resultGraph2);
mChart4 = (LineChart)findViewById(R.id.resultGraph4);
applySettings(mChart2);
applySettings(mChart4);

//...

void applySettings(LineChart chart)
{
    chart.setTouchEnabled(true);
    chart.setScaleEnabled(true);
    // etc...
}