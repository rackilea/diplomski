ArrayList<ArrayList<MyWeirdObject>> HM = new ArrayList<ArrayList<MyWeirdObject>>();
if (request.getAttribute("timePeriod").equals(null)) {
    HM = Test.getGlobalChallenge();
}
else {
    HM = Test.getGlobalChallengeByMonth(Test);
}