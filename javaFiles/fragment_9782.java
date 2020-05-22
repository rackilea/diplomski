class BrokenServer {
    void sendBrokenVoteData(ObjectOutputStream out) {
        out.writeObject(votes);
        changeVoteData(votes);
        out.writeObject(votes); // Writes a shared reference to "votes" WITHOUT updating any data.
    }
}

class FixedServer {
    void sendFixedVoteData(ObjectOutputStream out) {
        out.writeObject(votes);
        changeVoteData(votes);
        out.reset(); // Clears all shared references.
        out.writeObject(votes); // Writes a new copy of "votes" with the new data.
    }
}