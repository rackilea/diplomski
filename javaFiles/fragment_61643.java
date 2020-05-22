public class User implements Comparable<User> {
    String name;
    int score;

    public User(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int compareTo(User user){
        return user.getScore() - this.getScore();
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return "Name: " + name + " Score: " + score;
    }
}