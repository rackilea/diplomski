@Override
@Transactional(readOnly = true)
public List<Exam> getAllExams() {
  List<Exam> exams = examDao.getAllExams();
  for (Exam e : exams) {
    for (Question q : e.getQuestions()) {
      q.getAnswers().size();
    }
  }
  return exams;
}