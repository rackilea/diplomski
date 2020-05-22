ArrayList<Integer> bestStudentPosition = new ArrayList<Integer>();
 ArrayList<Integer> worstStudentPosition = new ArrayList<Integer>();
 double maxGrade = 0;
 double minGrade = 101;
 double avg = 0;
 double sum = 0;
 for(int i = 0; i < totalStudents; i++){
      System.out.print("Name: ");
      names[i] = input.next();
      System.out.print("Score: ");
      scores[i] = input.nextDouble();
      sum += scores[i];
      System.out.println("Running avg: " + (sum / (i + 1)); // for extra points
      if (scores[i] > maxGrade) {
          bestStudentPosition.clear(); // delete all previous students from list
          maxGrade = scores[i];
          bestStudentPosition.add(new Integer(i));
      } 
      else if (scores[i] == maxGrade) {  // if its same as some student(s) before, add this one to list too
           bestStudentPosition.add(new Integer(i)); 
      } else if (scores[i] < minGrade) {
           worstStudentPosition.clear();
           minGrade = scores[i];
           worstStudentPosition.add(new Integer(i));
      } else if (scores[i] == minGrade) {
           minGrade= scores[i];
           worstStudentPosition.add(new Integer(i));
      }

 }

 avg = sum/totalStudents;   // final avg
 System.out.println("The average score was: " + avg);  
 System.out.println("Best student(s):");
 for (Integer position : bestStudentPosition) { // print all best students
      System.out.println(maxGrade + ", " + names[position]);
 }
 System.out.println("Worst student(s):");
 for (Integer position : worstStudentPosition) { // print all worst students
      System.out.println(minGrade + ", " + names[position]);
 }