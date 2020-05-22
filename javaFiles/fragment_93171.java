float masterCoverage;
if (gitUrl.contains("pull/")) {
    final String myCorrectURL = "https://github.com/" + GitUtils.getUserRepo(gitUrl);
    // Using  masterCoverageRepository.get(myCorrectURL); is failing because URL is
    // https://github.com/USER/REPO/pull/PR_ID
    buildLog.println(BUILD_LOG_PREFIX + "myCorrectURL:" + myCorrectURL);
    masterCoverage = masterCoverageRepository.get(myCorrectURL);
} else {
    masterCoverage = masterCoverageRepository.get(gitUrl);
}