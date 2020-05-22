public class Player {

    private String surname;
    private int height;
    private int rank;
    private int age;
    private String firstName;

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "surname='" + surname + '\'' +
                ", height=" + height +
                ", rank=" + rank +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}