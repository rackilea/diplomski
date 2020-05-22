System.out.println(
  StringMetrics.overlapCoefficient().compare(
    "The quick brown fox", "The slow brawn fur")); // 0.25
System.out.println(
  StringMetrics.cosineSimilarity().compare(
     "The quick brown fox", "The slow brawn fur")); // 0.25