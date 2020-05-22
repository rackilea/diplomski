FileWriter writer = new FileWriter("C:\\Users\\Havok\\Google Drive\\Skripsie\\R\\JavaOut.csv");

for (int j = 0; j < wasp.length; j++) {
    writer.append(String.valueOf(wasp[j]));
    writer.append("\n");
}
writer.close();