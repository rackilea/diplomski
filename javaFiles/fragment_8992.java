import java.util.ArrayList;

public class Person{
    private String name;
    private ArrayList<Interest> interests = new ArrayList<Interest>();

    public Person(String name, ArrayList<Interest> interests) {
        this.name = name;
        this.interests = interests;
    }   

    public void addInterest(Interest newInterest) {
        interests.add(newInterest);
    }

    public Interest getInterest(int indexOfInterest) {
        return interests.get(indexOfInterest);
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String result = getName() + " ";
        for(Interest interest : interests) {
            result += interest.getName() + "(" + interest.getDangerRating() + ")" + " ";
        }
        return result.trim();
    }
}