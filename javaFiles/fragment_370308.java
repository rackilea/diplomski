@Override
public void itemStateChanged(ItemEvent e) 
{
    ((XYPlot) chart.getPlot())
        .setDataset(1, e.getStateChange() == ItemEvent.SELECTED ? 
                MovingAverage.createMovingAverage(dataset, "-MAVG", 3 * 24 * 60 * 60 * 1000L, 0L) : 
                null);
}