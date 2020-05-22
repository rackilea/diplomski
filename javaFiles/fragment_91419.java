int price;

if (Day.equals("Monday") || Day.equals("Tuesday") || Day.equals("Wednesday") || Day.equals("Thursday")) { //Monday - Thursday
    if (UserAge >= 10 && UserAge <=65) //10-65
        price = 10;
    else //Under 10 and Above 65
        price = 0;
} else { //Friday - Sunday
     if (UserAge >= 10 && UserAge <=65) //10-65
         price = 20;
     else //Under 10 and Above 65
         price = 10;
}