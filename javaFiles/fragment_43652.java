class Question {
private String content;
private Integer yesCnt;
private Integer noCnt;

public void vote(String answer) {
 if (answer.equals("yes") {
  yesCnt++;
 } else {
  noCnt++;
 }
}
}