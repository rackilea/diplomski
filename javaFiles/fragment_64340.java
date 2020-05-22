String weather = in.next();
if (weather.equals("snowy"))
    mpg -= 4;
else if (weather.equals("rainy"))
    mpg -= 1;
...
else System.out.println("Wrong input");