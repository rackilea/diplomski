class Team implements Comparable<Team> {
private gamesWon

//contructor/methods go here

@Override
public int compareTo(Team t) {
    int wins = t.gamesWon;
    if (this.gamesWon > wins) {
        return 1;
    } else if (this.gamesWon == wins) {
        return 0;
    } else {
        return -1;
    }
}