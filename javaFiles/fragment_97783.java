/* Using the String#toUpperCase() method ensures that 
   we don't need to worry about what letter case happens
   to be in orgid.    */
switch (orgid.toUpperCase()) {
    case "G":
    case "ZG":
    case "S":
        filename = "N_" + df.format(date) + ".txt";
        break;
    case "L":
        filename = "D_" + df.format(date) + ".txt";
        break;
    case "F":
    case "IV":
        filename = "F_" + df.format(date) + ".txt";
        break;
    default:
        System.err.println("Can Not Establish A Proper File Name (missing prefix)!");
        return;
}