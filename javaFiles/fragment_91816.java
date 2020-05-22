String csv = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
CSVWriter writer = new CSVWriter(new FileWriter(csv));

List<String[]> data = new ArrayList<String[]>();
data.add(new String[] {"India", "New Delhi"});
data.add(new String[] {"United States", "Washington D.C"});
data.add(new String[] {"Germany", "Berlin"});

writer.writeAll(data);

writer.close();