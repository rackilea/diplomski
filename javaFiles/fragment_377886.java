public class ClassThatHandlesStatistics {
    private final List<StatisticsListener> listeners = new CopyOnWriteArrayList<StatisticsListener>();

    public void doSomething(){
         Statistics changed ... //do your logic
         fireStatisticsChanged(new StatisticsEvent(changed));
    }

    protected void fireStatisticsChanged(StatisticsEvent evt){
        for (StatisticsListener listener : listeners){
             listener.statisticsChanged(evt);
        }
    }
}