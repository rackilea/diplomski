CSVWriter writer = new CSVWriter(new FileWriter("/home/user/file" + i + ".csv"),',') ;
for (Integer i : arlist) {
    writer.writeNext(new String[]{i.toString()});
}
writer.close();
arlist.clear();