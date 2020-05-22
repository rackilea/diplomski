if (az_za == 1) {
    Arrays.sort(names);
} else if (az_za == 2) {
    Arrays.sort(names, Collections.reverseOrder());
} 

for (String namePart: names) {
    System.out.print(namePart + "   ");
}