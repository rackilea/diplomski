static class User {
    final String name;
    public User(String s) { name = s; }
}
static class UserWithdrawls {
    final User user;
    final double[] withdrawals;
    final ValueSummary summary;
    UserWithdrawls(User user, double[] withdrawals) {
        this.user = user;
        this.withdrawals = withdrawals;
        this.summary = ValueSummary.createFor(withdrawals);
    }
}
public static void main(String[] args) {
    UserWithdrawls[] userWithdrawls = {
            new UserWithdrawls(new User("John"), new double[] { 1, 2, 3}),
            new UserWithdrawls(new User("Doe"), new double[] { 10, 22, 30})
    };
    for (UserWithdrawls uw : userWithdrawls) {
        System.out.println("User: " + uw.user.name);
        System.out.println(uw.summary);
    }
}