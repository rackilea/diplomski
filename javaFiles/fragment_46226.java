int contient = 4;
String contientString;

switch (contient) {
    case 1:
        contientString = "North America: Mexico city Mexico";
        break;
    case 2:
        contientString = "Some 2nd Continent: Some 2d City Some2ndCountry";
        break;
    case 3:
        contientString = "Some 3rd Continent: Some 3rd City Some3rdCountry";
        break;
    case 4:
        contientString = "Some 4th Continent: Some 4th City Some4thCountry";
        break;
    default:
        contientString = "Don't Know What Continent: UNKNOWN";
}

System.out.println(contientString);