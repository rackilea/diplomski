String currLine;
while ((currLine = r.readLine()) != null) {
    if (currLine.trim().length() > 0) {
        String[] split = currLine.split(";");
        itemArr.add(Integer.parseInt(split[0]));
        descArr.add(split[1]);
    }
}