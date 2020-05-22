FileInputStream fs= new FileInputStream("quotes.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fs));
ArrayList<String> array = new ArrayList<>();
String line;
while((line = br.readLine()) != null)
  array.add(line);
// variable so that it is not re-seeded every call.
Random rand = new Random();

// nextInt is exclusive. Should be good with output for array.
int randomIndex = rand.nextInt(array.size());

// Print your random quote... 
System.out.println(array.get(randomIndex));