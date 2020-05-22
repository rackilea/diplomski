List <Customer> custList = new ArrayList <Customer>();
CSVReader reader = new CSVReader (new FileReader (file));
String[] header = reader.readNext();
if (header == null)
{
    throw new RuntimeException("No header");
}

String[] row;
while ((row = reader.readNext()) != null)
{
    if (row.length != 3) {
        throw new RuntimeException("Unexpected number of entries: " + row.length);
    }
    custList.add(new Customer(row[0], row[1], row[2]));
}