String rawdata = "900,300,Ernest,Fuller\n777,555,Henry,Miller\n";

String[] records = rawdata.split("\n");

List<BaseRecord> baseRecords = new ArrayList<BaseRecord>();

for (String record: records) {
    String [] recordData = record.split(",");

    baseRecords.add(new BaseRecord(Integer.parseInt(recordData[0]), Integer.parseInt(recordData[1]), recordData[2], recordData[3]));
}