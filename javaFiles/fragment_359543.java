public static final double MIN_SCORE = 0.3;

public List<Match> findMatches(String searchFirst, String searchLast) {
  List<Match> results = new ArrayList<Match>();

  // Keep in mind that this doesn't scale well.
  // With only 1000 names that's not even a concern a little bit, but
  // thinking ahead, here are two ideas if you need to:
  // - Keep a map of firstnames.  Each entry should be a map of last names.
  //   Then, only iterate through last names if the firstname score is high
  //   enough.
  // - Score each unique first or last name only once and cache the score.
  for(PersonDO person: personCache.values()) {
    // Some of my own ideas follow, you can tweak based on your
    // knowledge of the data)

    // No reason to deal with the combined name, that just makes things
    // more fuzzy (like your problem of too-high scores when one name
    // is completely missing).
    // So, score each name individually.

    double scoreFirst = scoreName(searchFirst, person.getFirstName());
    double scoreLast = scoreName(searchLast, person.getLastName());

    double score = (scoreFirst + scoreLast)/2.0;

    // Add tweaks or alternate scores here.  If you do alternates, in most
    // cases you'll probably want to take the highest, but you may want to
    // average them if it makes more sense.

    if (score > MIN_SCORE) {
      results.add(new Match(person, score));
    }
  }

  return ImmutableList.copyOf(results);
}