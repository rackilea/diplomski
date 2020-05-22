BufferedReader br = new BufferedReader(new FileReader(new File("TestScanner.txt")));
StringBuffer buff = new StringBuffer();
String line = null;
while ((line = br.readLine()) != null) {
    buff.append(line);
}
String result = buff.toString().replaceAll("[\\-]*[^0-9]+[\\.]*[^0-9]+", " ");
System.out.println(Arrays.asList(result.trim().split(" ")));