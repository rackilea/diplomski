Student hobbit = new Student(HomeworkAve,QuizAve, ProjectAve,TestAve,FirstName, LastName);


double hobbitsfinalGrade = hobbit.CalcGrade(HomeworkAve,QuizAve, ProjectAve,TestAve);
String hobbitsletterGrade = hobbit.CalcGrade(hobbitsfinalGrade);

students.add(hobbit);