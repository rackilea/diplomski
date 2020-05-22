public class Project implements Comparable<Project> {

    @Override
    public int compareTo(Project other) {
        return this.id - other.id; // or whatever property you want to sort
    }