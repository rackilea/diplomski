double firstGrade = getGrade(firstClass);
double secondGrade = getGrade(secondClass);
double thirdGrade = getGrade(thirdClass);
double fourthGrade = getGrade(fourthClass);
double fifthGrade = getGrade(fifthClass);

// Use your switch statement.... no break(s) because we return.
public static double getGrade(String grade) {
  switch (grade){
  case "A+": return 4.33;
  case "A": return 4.00;
  case "A-": return 3.67;
  case "B+": return 3.33;
  case "B": return 3.00;
  case "B-": return 2.67;
  case "C+": return 2.33;
  case "C": return 2.00;
  case "C-": return 1.67;
  case "D+": return 1.33;
  case "D": return 1.00;
  case "D-": return .67;
  }
  // F
  return 0.0;
}