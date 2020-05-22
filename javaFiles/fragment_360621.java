List<Can> yourList = new ArrayList<>();
while ((line = reader.readLine()) != null) {

    String[] wordRead = line.split(',');
    yourList.add(new Can(wordRead[0], wordRead[1]));
}