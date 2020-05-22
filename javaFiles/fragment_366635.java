public class SportCompetition extends Event {

    int numberOfActivities;
    Season season;

    public SportCompetition(int year, int month, int numberOfCities, int numberOfActivities, Season season) {
        super(year, month, numberOfCities);
        this.numberOfActivities = numberOfActivities;
        this.season = season;
    }
}

enum Season {
    SUMMER, FALL, WINTER, SPRING
}