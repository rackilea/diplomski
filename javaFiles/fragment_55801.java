String name = dataRecords[0];
String cardNumber = dataRecords[1];
int pin = Integer.parseInt(dataRecords[2]); //to convert the String back to int
double balance = Double.parseDouble(dataRecords[3]);

Account account = new Account(name, cardNumber, pin, balance);
accountList.add(account);