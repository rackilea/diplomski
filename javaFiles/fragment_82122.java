...
@Autowired
private QuizRepository quizRepository;

public void deleteQuiz(Quiz quiz) {
   quizRepository.delete(quiz);
}
...