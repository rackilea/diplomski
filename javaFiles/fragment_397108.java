List<Student> students = ...

DoubleSummaryStatistics stats = students.stream()
    .mapToDouble(Student::getQuiz1)
    .summaryStatistics();
double quiz1average = stats.getAverage();
double quiz1max = stats.getMax();
// etc.

// And likewise for quiz2:
DoubleSummaryStatistics stats = students.stream()
    .mapToDouble(Student::getQuiz2)
    .summaryStatistics();