BufferedReader bfr = new BufferedReader(InputStreamReader/FileReader...);
String line = null;
int index = 0;
String [][] xyz = new String [100][5];

while ( (line = bfr.readLine()) != null) {
    if (index < xyz.length) xyz[index] = line.split(",");
    index++;
}