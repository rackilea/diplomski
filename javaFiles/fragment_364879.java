QuizAnswer firstTrue = QuizAnswer(true, false, false, false);
assertTrue(firstTrue.isFirstAnswer());
// Then for next:
QuizAnswer secondTrue = QuizAnswer(false, true, false, false);
assertTrue(secondTrue.isSecondAnswer());
// Etc. You could also check if all other answers are false