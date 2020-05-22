import javax.swing.ImageIcon;

class Team {

    public String name;
    public ImageIcon logo;
    public int points;
    public int plusGoals;
    public int minGoals;
    public int goalsTotal;

    public Team(String name, String location, int points, int plusGoals,
            int minGoals, int goalsTotal) {
        this.logo = new ImageIcon(location); // using ImageIcon(URL location)

        this.name = name;

        this.points = points;
        this.plusGoals = plusGoals;
        this.minGoals = minGoals;
        goalsTotal = plusGoals - minGoals;
    }

    public void print() {
        System.out.println("\n" + name + "\n" + logo + "\n" + points + "\n"
                + plusGoals + "\n" + minGoals + "\n" + goalsTotal);

    }
}

public class imageicon {

    public static void main(String[] args) {

        Team obj = new Team("a", "C:\\Users\\path.png", 1, 2, 3, 4);
        obj.print();

    }
}