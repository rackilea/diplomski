// class level declaration
Map<Double, String> timeSeriesMap = new HashMap<Double, String>();

while ((line = br.readLine()) != null) {
    // split current line on any amount of whitespace
    String[] parts = line.trim().split("\\s+");
    Double key     = Double.valueOf(parts[0]);
    String value   = parts[1];

    // add the (key, value) pair to your Map
    timeSeriesMap.put(key, value);

    System.out.println(line);
}