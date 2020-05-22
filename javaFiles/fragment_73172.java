public class ReviewSpammer {
    private ArrayList<String> phrases;
    private ArrayList<String> stories;
    private ArrayList<FakeUser> users;

    public ReviewSpammer() {
        phrases = new ArrayList<>();
        stories = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addPhrase(String newPhrase){
        phrases.add(newPhrase);
    }

    public void addStory(String newStory){
        stories.add(newStory);
    }

    public void addUser(FakeUser newUser){
        users.add(newUser);
    }
}