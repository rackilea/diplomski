public interface Team {
}

public interface Event {
}

public abstract class Fixture<T extends Team> implements Event {
}

public abstract class Forecast<T> {
}

public class MyPrediction<T extends Fixture<? extends Team>> extends
        Forecast<Fixture<? extends Team>> {
}

public class SoccerFixture<T extends SoccerTeam> extends Fixture<T> {
}

public class SoccerTeam implements Team {
}

public class EnglishSoccerTeam extends SoccerTeam {
}

public class Predictor {

    public <T extends Fixture<? extends Team>> MyPrediction<T> getMyPrediction(T fixture) {
        return new MyPrediction<T>();
    }

    public void doit() {
        SoccerFixture<EnglishSoccerTeam> soccerMatch = new SoccerFixture<EnglishSoccerTeam>();
        MyPrediction<SoccerFixture<EnglishSoccerTeam>> myPrediction = getMyPrediction(soccerMatch);
    }
}