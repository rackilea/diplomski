public List<String> getRapperName() {
  return makeList(rapperList, Rapper::getRapperName);
}

public List<String> getMusicianName() {
  return makeList(musicianList, Musician::getMusicianName);
}