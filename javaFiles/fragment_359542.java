// Typos on first letter are much more rare.  Max score 0.3
public static final double MAX_SCORE_FOR_NO_FIRST_LETTER_MATCH = 0.3;

public double scoreName(String searchName, String candidateName) {
  if (searchName.equals(candidateName)) return 1.0

  int editDistance = StringUtils.getLevenshteinDistance(
      searchName, candidateName);

  // Normalize for length:
  double score =
      (candidateName.length() - editDistance) / candidateName.length();

  // Artificially reduce the score if the first letters don't match
  if (searchName.charAt(0) != candidateName.charAt(0)) {
    score = Math.min(score, MAX_SCORE_FOR_NO_FIRST_LETTER_MATCH);
  }

  // Try Soundex or other matching here.  Remember that you don't want
  // to go above 1.0, so you may want to create a second score and
  // return the higher.

  return Math.max(0.0, Math.min(score, 1.0));
}