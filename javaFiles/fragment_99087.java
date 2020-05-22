int price = 100;
int price1 = 5000;
int price2 = 2000;
int price3 = 20000;
int price4 = 500;
int price5 = 50;

ThisIsGarage garage = new ThisIsGarage();
int tally = garage.addValues(price).
        addValues(price1).
        addValues(price2).
        addValues(price3).
        addValues(price4).
        addValues(price5)
        .tally();
System.out.println(tally);