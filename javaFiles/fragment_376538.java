static class User {
    final String name;
    public User(String s) { name = s; }
}
public static void main(String[] args) {
    User[] users = { new User("John"), new User("Doe")};
    double[][] withdrawals = {
         new double[] { 1, 2, 3}, new double[] { 10,22, 30} 
    };
    for (int i = 0; i < users.length; i++) {
        System.out.println("User: " + users[i].name);
        System.out.println(ValueSummary.createFor(withdrawals[i]));
    }
}