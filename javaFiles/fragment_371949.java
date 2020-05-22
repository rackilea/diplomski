function getString(number) {
    var numstring = "";
    var num = number;
    while (num > 0) {
        numstring = num % 10 + numstring;
        num -= num % 10;
        num /= 10;
    }
    return numstring;
}
var number = 1344810353;
log(getString(number)); // or however your output it