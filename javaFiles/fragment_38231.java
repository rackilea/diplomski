for (int b = 0; b < classes; b++) {
    Scanner input3 = new Scanner(System.in);
    System.out.println("Enter credit hours for class :"+(b + 1));
    credits = input2.nextDouble();
    System.out.println("credits:" + credits);
    totalCredits += credits;
    System.out.println(" ");
    System.out.println("Enter grade for class : "+(b + 1));
    grades = input3.nextLine();

   }