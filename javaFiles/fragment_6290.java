public class PersonTest {
    public static void main(String[] args) {
        Person johndoe = new Person("John Doe");
        Person janedoe = new Person("Jane Doe");
        Person danedoe = new Person("Dane Doe");

        johndoe.addFriend(janedoe);
        janedoe.addFriend(danedoe);

        johndoe.printFriends();
        janedoe.printFriends();
        danedoe.printFriends();
    }
}