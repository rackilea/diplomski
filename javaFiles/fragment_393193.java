String[] names = new String[] {"_id", "flag", ....};
for (int i = 0; i < mArrayList.size(); i++) {
    Record record = mArrayList.get(i);

    String current = "";
    List<String> values = record.getValues();
    for (int j = 0; j < values.size(); j++) {
        String fieldName = names[j];
        String s = values.get(j);
        current += " " + fieldName + "=" + s;
    }
    B = B + "[" + current.trim() + "]";
}
System.out.println(B); // will print: [_id=value1 flag=value2 ...][_id=value1 flag=value2 ...] etc