String line = null;
while ((line = reader.readLine()) != null) {
    PRIvariable pri = new PRIvariable();
    String[] values = line.split(",");
    pri.dateText = values[2] + "    " + values[4];
    pri.count = pri.count + 1;
    pri.sum = pri.sum + Integer.parseInt(values[7]);
    System.out.println(pri.dateText + "  " + pri.sum + " " + pri.count);
    ar.add(pri);
}