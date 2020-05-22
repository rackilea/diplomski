Scanner scan = new Scanner(new File(copyUri));
ArrayList<String[]> records = new ArrayList<String[]>();
String[] record = new String[2];
while(scan.hasNext()) {
        record = scan.nextLine().split(",");
        records.add(record);
}
int rows = records.size();
String[] a = new String[rows];
String[] b = new String[rows];
String[] c = new String[rows];
String[] d = new String[rows];
int j = 0;
for (String[] temp : records) {
    a[j] = temp[0];
    b[j] = temp[1];
    c[j] = temp[2];
    d[j] = temp[3];
    j++;
}