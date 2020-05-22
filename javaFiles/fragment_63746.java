double j = 30;
    for (double i = 31; i <= 40; i++) {
        System.out.print(i + "\t\t" + "\t" +celsiusToFahrenheit(i)+"\t\t\t" +j + "\t\t\t\t"+fahrenheitToCelsius(j));
        System.out.println("");
        j+=10; // since i has 10 values (31 to 40), j must increment by 10 in each 
               // iteration in order for it to have 10 values between 30 and 120
    }