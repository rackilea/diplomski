int found = 0;
for ($Fisherman fisherman : fishermen) {
    if (fisherman.getSSN().equals(searchSSN)) {
        found = 1;
        System.out.println(fisherman);
        break;
    }
if (found == 0) {
    System.out.println("No match for that fisherman");
    fishermanMenu();               
}
else {
    found = 0;
    fishermanMenu();
}