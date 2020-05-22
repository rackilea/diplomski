public class UserBuilder implements Builder<User> {

     public void withName(String name) {
         // ...
     }

     public void withAge(int age) {
         // ...
     }

     public User build() {
         User user = new User();
         user.setName(...);
         user.setAge(...);
         return user;
     }

}

public class AccountBuilder implements Builder<Account> {

    public void setCountry(String country) {
         // ...
    }

    public void setNumber(String number) {
         // ...
    }

    public void setCode(String code) {
         // ...
    }

    public Account build() {
         Account account = new Account();
         account.setCountry(...);
         account.setNumber(...);
         account.setCode(...);
         return account;
    }
}