DataInterface dataInterface; // Declare as a member.
// Use it everywhere freely without worrying.


// In maybe a constructor put following.

String dataInterfaceImplementationValue;

// Code to read properties file and get value of dataInterfaceImplementationValue.

if (dataInterfaceImplementationValue.equals("XML")) {
    dataInterface = new XmlDataInterface();
} else if (dataInterfaceImplementationValue.equals("SQL") {
    dataInterface = new SqlDataInterface();
} else {
    System.out.println("Invalid property set: " + dataInterfaceImplementationValue);
}