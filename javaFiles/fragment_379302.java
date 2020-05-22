final String operatingSystem = System.getProperty("os.name");

if (operatingSystem .contains("Windows")) {
    Runtime.getRuntime().exec("cls");
}
else {
    Runtime.getRuntime().exec("clear");
}