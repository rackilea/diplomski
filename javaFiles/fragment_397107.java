public enum Quiz {
  QUIZ_1,
  QUIZ_2,
  QUIZ_3,
  QUIZ_4,
  MID_TERM_1,
  MID_TERM_2,
  FINAL_TEST
}

public final class Student {
  private final EnumMap<Quiz, Double> grades
      = new EnumMap<>(Quiz.class);

  public void setGrade(Quiz quiz, double grade) {
    grades.put(quiz, grade);
  }

  public double getGrade(Quiz quiz) {
    Double grade = grades.get(quiz);
    if (grade == null) {
      throw new IllegalArgumentException(
          "Student has no grade yet for quiz " + quiz);
    }
    return grade;
  }
}

static double computeAverage(List<Student> students, Quiz quiz) {
  double sum = 0;
  for (Student student : students) {
    sum += student.getGrade(quiz);
  }
  return sum / students.size();
}