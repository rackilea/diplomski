public interface Athlete {}
public interface RunnerAthlete extends Athlete {
 int participate(RunningRace race);
}
public interface SwimmerAthlete extends Athlete {
 int participate(SwimmingRace race);
}