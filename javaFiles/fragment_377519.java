Table t = db.getTable("NTEP SAMPLES LIST");
int countNotNull = 0;
int countAtLeast12 = 0;
for (Row r : t) {
    String s = r.getString("CURRENTGAC");
    if (s != null) {
        countNotNull++;
        Double d = Double.parseDouble(s);
        if (d >= 12.00) {
            countAtLeast12++;
        }
    }
}
System.out.println(String.format(
        "Scan complete. Found %d non-null CURRENTGAC values, %d of which were >= 12.00.", 
        countNotNull, 
        countAtLeast12));