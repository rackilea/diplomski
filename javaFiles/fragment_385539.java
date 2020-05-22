dateIsValid = true;
switch (month) {
    case 2:
        maxday = 28;
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        maxday = 30;
        break;
    default:
        if (month > 12) {
            dateIsValid = False;
        }
        maxday = 31;
        break;
}
if (day < 1 || day > maxday) {
    dateIsValid = false;
}
if (!dateIsValid) {
    System.out.println("Invalid Date");
}