public class JoggingTrack {
    public synchronized boolean thereIsSpace() {
        return (numOfAthletes < 5);
    }
    public synchronized void addAthlete() {
        numOfAthletes++;
    }
    ...