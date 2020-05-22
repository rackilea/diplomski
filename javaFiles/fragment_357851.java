String text = "DESTINATION: 71222222 PRIORITY: urgent AUTRE: rien";

StringTokenizer tokinizer = new StringTokenizer(text,": ");

while(tokinizer.hasMoreTokens()) {
    tokinizer.nextToken();  //skip first
    System.out.println(tokinizer.nextToken());
}