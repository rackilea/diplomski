String e = "Days";
String value = "Monday";

if (e.equalsIgnoreCase(Enumerations.Days.class.getSimpleName())) {
    System.out.println(Enumerations.Days.valueOf(value).getValue());
} else if (e.equalsIgnoreCase(Enumerations.Months.class.getSimpleName())) {
    System.out.println(Enumerations.Months.valueOf(value).getValue());
} else {
    System.out.println("Could not find enum");
}