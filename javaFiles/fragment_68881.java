public List<String> getRapperName() {
  return makeList(rapperList, new Function<Rapper, String>() {
    @Override public String apply(Rapper r) {
      return r.getRapperName();
    }
  });
}

public List<String> getMusicianName() {
  return makeList(musicianList, new Function<Musician, String>() {
    @Override public String apply(Musician m) {
      return m.getMusicianName();
    }
  });
}