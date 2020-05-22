BufferedReader reader = new BufferedReader(
   new InputStreamReader(new BufferedInputStream(System.in)));

try {
    StringBuilder result = new StringBuilder();

    for (String line = null; (line = reader.readLine()) != null;) {
        result.append(line);
    }
    //process result
    System.out.println(result);
} catch (IOException e){
    e.printStackTrace();
}