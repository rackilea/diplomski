static class Item {
    String str;
    Double value;

    public Item(String str, Double value) {
        this.str = str;
        this.value = value;
    }
}
public static void main (String[] args) throws IOException {
    ArrayList<Item> rows = new ArrayList<Item>();
    BufferedReader reader = new BufferedReader(new FileReader("avgGen.txt"));

    String s;
    while((s = reader.readLine())!=null){
        String[] data = s.split(",");
        double avg = Double.parseDouble(data[0]);
        rows.add(new Item(data[1], avg));
    }

    Collections.sort(rows, new Comparator<Item>() {

        public int compare(Item o1, Item o2) {
            if (o1.value < o2.value) {
                return -1;
            } else if (o1.value > o2.value) {
                return 1;
            }
            return 0;
        }
    });

    FileWriter writer = new FileWriter("output.txt");
    for(Item cur: rows)
        writer.write(cur.value + "," +  cur.str + "\n");

    reader.close();
    writer.close();
}