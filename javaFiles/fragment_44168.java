String [][] databases = new String[numberOfDatabases][itemsInEachDatabase];

for (int i = 0; i < itemsInEachDatabase; i++) {
  databases[0][i] = database_1[i];
}
// repeat this for loop for other databases

for (int i = 0; i < numberOfDatabases; i++) {
  if (databases[i][0].equalsIgnoreCase(data)) {
    // your code here
  }
}