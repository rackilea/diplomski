int price = 100;
int price1 = 5000;
int price2 = 2000;
int price3 = 20000;
int price4 = 500;
int price5 = 50;

ThisIsGarage garage = new ThisIsGarage();
garage.addValues(price);
garage.addValues(price1);
garage.addValues(price2);
garage.addValues(price3);
garage.addValues(price4);
int tally = garage.addValues(price5);
System.out.println(tally);