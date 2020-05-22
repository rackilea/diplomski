public class AddInterestListener implements ActionListener {
     private final Account account;

     public AddInterestListener(final Account account) {
         this.account = account;
     }

     public void actionPerformed(Event e) {
      ...
          account.deposit(interest);
      ...
     }
}