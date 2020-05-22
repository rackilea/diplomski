Pattern natPattern1 = Pattern.compile("^\\d{8}$");
Pattern natPattern2 = Pattern.compile("^\\d{7}-\\d{1}$");

Pattern pctPattern1 = Pattern.compile("^PCT/?[A-Z]{2}?\\d{4}/\\d{6}$");
Pattern pctPattern2 = Pattern.compile("^PCT[A-Z]{2}\\d{10}$");
Pattern pctPattern3 = Pattern.compile("^P[A-Z]{2}\\d{8}$");

Pattern itsPattern1 = Pattern.compile("^ITS/?[A-Z]{2}?\\d{2}/\\d{5}$");
Pattern itsPattern2 = Pattern.compile("^ITS[A-Z]{2}\\d{7}$");
Pattern itsPattern3 = Pattern.compile("^I[A-Z]{2}\\d{7}$");