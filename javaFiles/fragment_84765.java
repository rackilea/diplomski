double average;
        double total = 0;
  for (int index = 0; index < x; index++) {
        System.out.println("Enter student " + (index + 1) + "'s " + "grade");
        total += input.nextInt();
    }

        System.out.println("The average grade is");
        average = total / X;
        System.out.println(average);