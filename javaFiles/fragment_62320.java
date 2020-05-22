String curl = "curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{\"field1\": \"value1\", \"field2\": \"value2\"}' 'http://localhost:8080/service'";
System.out.println(curl);
try {
    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec(curl);
    process.waitFor();
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); //BufferedReader to read the output
    StringBuilder sb = new StringBuilder(); //What will hold the entire console output
    String line = ""; //What will hold the text for a line of the output
    while ((line = reader.readLine()) != null) { //While there is still text to be read, read it
        sb.append(line + "\n"); //Append the line to the StringBuilder
    }
    System.out.println(sb); //Print out the full output
} catch (Exception e) {
    e.printStackTrace();
}