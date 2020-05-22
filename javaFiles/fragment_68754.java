Scanner s = new Scanner("someFile.txt");
Location locations = new Location[numberOfRowsInFile];
int i = 0;
while(i < numerOfRowsInFile) {
    String line = s.nextLine();
    String[] coordinate = line.split("\\s+");
    locations[i++] = new Location(Double.parseDouble(coordinate[1]),Double.parseDouble(coordinate[2])); //Parse coordinates
}