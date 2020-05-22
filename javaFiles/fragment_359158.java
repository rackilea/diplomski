BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader(filenameIn));
    reader.readLine();
    for (int i = 0; i < personArray.length; i++) {
        String[] data = reader.readLine().split("\\t"); // <-- to split on tab.
        personArray[i] = new Person(Integer.parseInt(data[0]), 
                data[1], data[2], Integer.parseInt(data[3]));
    }
} catch (IOException e) {
    System.out.println("ERROR: WRONG FILE " + e.toString());
} catch (Exception e) {
    System.out.println("ERROR" + e.toString());
} finally {
    if (reader != null) {
        reader.close();
    }
}