public class StatisticsEvent {
    private final Statistics changedStatistics;

    public StatisticsEvent(Statistics changedStatistics){
         this.changedStatistics = changedStatistics;
    }

    public Statistics getChangedStatistics(){
         return this.changedStatistics;
    }
}