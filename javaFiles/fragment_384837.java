int num[] = {3, 4, 5};
String[] values = new String[]{"AB", "BC", "CD"};

HashMap<Integer,String> lineValueMap = new HashMap();
for(int i=0 ;i<num.length ; i++) {
    lineValueMap.put(num[i],values[i]);
}


FileInputStream fs = new FileInputStream("test.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fs));

FileWriter writer1 = new FileWriter("test1.txt");

int count = 1;
String line = br.readLine();
while (line != null) {
    String replaceValue = lineValueMap.get(count);
    if(replaceValue != null) {
        writer1.write(replaceValue);
    } else {
        writer1.write(line);
    }
    writer1.write(System.getProperty("line.separator"));
    line = br.readLine();
    count++;
}
writer1.flush();