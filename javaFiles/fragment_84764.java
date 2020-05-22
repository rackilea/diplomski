double average;
        double total = 0;
  for (int index = 0; index < grades.length; index++) {
        System.out.println("Enter student " + (index + 1) + "'s " + "grade");
        grades[index] = input.nextInt();
        total += grades[index];
    }

        System.out.println("The average grade is");
        average = total / X;
        System.out.println(average);