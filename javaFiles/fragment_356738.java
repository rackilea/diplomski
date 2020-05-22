public class RunnerAthleteImpl implements RunnerAthlete {
    int participate(RunningRace race) {}
}

public class TriAthleteImpl implements RunnerAthlete, SwimmerAthlete, HurdlerAthlete {
    int participate(RunningRace race) {}
    int participate(SwimmingRace race) {}
    int participate(HurdleRace race) {}
}