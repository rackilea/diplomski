InputStream in = new URL(url).openStream();
Scanner scanner = new Scanner(new InputStreamReader(in));
String result = scanner.useDelimiter("\\Z").next(); // this reads the whole
                                                    // script output in a string
if(result.equals("false"))
 handle the false value...
else
  dati = gsonReader.fromJson(result, Applicazioni.class);