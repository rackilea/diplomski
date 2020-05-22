public Match findClosestMatch(String searchFirst, String searchLast) {
  List<Match> matches = findMatch(searchFirst, searchLast);

  // Tweak here

  return Match.SCORE_ORDER.max(list);
}