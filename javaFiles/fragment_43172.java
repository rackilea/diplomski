Scanner scan = new Scanner(new File(copyUri));
ArrayList<String[]> records = new ArrayList<String[]>();
String[] record = new String[2];
ArrayList<String[]> a = new ArrayList<String[]>();
ArrayList<String[]> b = new ArrayList<String[]>();
ArrayList<String[]> c = new ArrayList<String[]>();
ArrayList<String[]> d = new ArrayList<String[]>();

while(scan.hasNext())
{
    record = scan.nextLine().split(",");
    a.add(record[0]);
    b.add(record[1]);
    c.add(record[2]);
    d.add(record[3]);
    records.add(record);
}