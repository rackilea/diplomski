ArrayList<ArrayList<MyWeirdObject>> HM = new ArrayList<ArrayList<MyWeirdObject>>();
if (request.getAttribute("timePeriod").equals(null)) {
    ArrayList<ArrayList<MyWeirdObject>> HM = Test.getGlobalChallenge();
}
else {
    ArrayList<ArrayList<MyWeirdObject>> HM = Test.getGlobalChallengeByMonth(Test);
}