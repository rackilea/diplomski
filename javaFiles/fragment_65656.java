URL oracle = new URL("http://finance.yahoo.com/q?s=AAPL");
BufferedReader in = new BufferedReader(
new InputStreamReader(oracle.openStream()));
StringBuilder sb=new StringBuilder();
String inputLine;
while ((inputLine = in.readLine()) != null)
    sb.append(inputLine);
in.close();
String data=sb.toString();