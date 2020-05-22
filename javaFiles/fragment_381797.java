switch (month) {

case 1: // --> month == 1 here
    if (day < 20) {
        zodiac = "Capricorn";
    } else if (day >= 20 && day <=31) {
        zodiac = "Aquarius";
    }
case 2: // --> month == 2 here
    if (day < 19) {
        zodiac = "Aquarius";
    } else if (day >= 19 && day <= 29)
        zodiac = "Pisces";
    break;

    // etc 
}