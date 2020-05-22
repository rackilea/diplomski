public static ATMCard createCard(String name, int accNo, int pin, int initBal) {
   Account acc = new Account(name, accNo, initBal);
   ATMCard card = new ATMCard(pin);
   card.setAccount(acc);
   return card; 
}