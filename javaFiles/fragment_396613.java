public class Main {
    public static void main(String[] args) {

        Athlete[] eAthlete = new Athlete[5];
        String[] names = { "ss", "aa", "bb", "cc", "xx" };

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < eAthlete.length; i++) {
            eAthlete[i] = new Athlete();
            eAthlete[i].setName(names[i]);
            System.out.println("Please enter Grade for: "
                    + eAthlete[i].getName());
            eAthlete[i].setGrade(in.nextLine());
        }

        in.close();

        // Print all athletes with their grades,
        System.out.println("Before Sorting");
        for (Athlete s : eAthlete) {
            System.out.println(s.getName() + " " + s.getGrade());
        }

        String tempStr;

        for (int t = 0; t < eAthlete.length - 1; t++) {
            for (int i = 0; i < eAthlete.length - t - 1; i++) {
                if (eAthlete[i + 1].getName().compareTo(eAthlete[i].getName()) < 0) {
                    tempStr = eAthlete[i].getName();
                    eAthlete[i].setName(eAthlete[i + 1].getName());
                    eAthlete[i + 1].setName(tempStr);
                }
            }
        }

        System.out.println("After Sorting");
        for (Athlete s : eAthlete) {
            System.out.println(s.getName() + " " + s.getGrade());
        }
    }
}

class Athlete {

    private String name;
    private String grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String gr) {
        grade = gr;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

}