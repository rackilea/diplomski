String[] allData = new String[data.length + data2.length];
System.arraycopy(data, 0, allData, 0, data.length);
System.arraycopy(data2, 0, allData, data.length, data2.length);

try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(binaryReference)))) {
    out.write(allData);
}