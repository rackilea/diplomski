switch(string) {
   case "car":
        output("Car: " + string);
        break;
    case "cat":
    case "dog":
    case "mouse":
        output("Animal: " + string);
        break;
    default:
        output("Unknown");
        break;
}