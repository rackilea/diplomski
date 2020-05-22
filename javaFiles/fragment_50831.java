public Driver(String dataLine) {
    String str = dataLine.substring(1, dataLine.length() - 1);
    String[] data = str.split(",");
    name = data[0].replace("(", "").trim();//remove "("
    time = new Time[data.length - 1];

    for (int x = 0; x < time.length; x++) {
        time[x] = new Time(data[x + 1].trim());
    }
    }