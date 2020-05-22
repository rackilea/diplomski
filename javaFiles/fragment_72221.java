BestTimes[] beginner, intermediate, expert;
try(FileInputStream in = new FileInputStream("file.txt");
    ObjectInputStream s = new ObjectInputStream(in)) {
    beginner = (BestTimes[]) s.readObject();
    intermediate = (BestTimes[]) s.readObject();
    expert = (BestTimes[]) s.readObject();
}