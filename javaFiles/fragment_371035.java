int sizeOfTheQuiz = 6;
ArrayList<String> quizzes = new ArrayList<>(sizeOfTheQuiz);

ArrayList<TextView> tvAnswers = new ArrayList<>();
tvAnswers.add(ans1);
tvAnswers.add(ans2);
tvAnswers.add(ans3);
tvAnswers.add(ans4);
tvAnswers.add(ans5);
tvAnswers.add(ans6);

// size of the quizzes must not larger than tvAnswers
for(int i = 0; i < quizzes.size(); i++) {
  tvAnswers.get(i).setText(quizzes.get(i));
}