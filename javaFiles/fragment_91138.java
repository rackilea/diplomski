Scanner sc = new Scanner(System.in);
    System.out.print("How many courses did you take during the school year? : ");
    int takeCoursesNum = sc.nextInt();

    int grades[] = new int[takeCoursesNum]; // array number start "0" ~ ex) { [0], [1], [2] }

    for (int i = 0; i < takeCoursesNum; i++) {
        System.out.print("Enter your grade for that course : ");
        int grade = sc.nextInt();
        grades[i] = grade;
    }

    for (int i = 0; i < takeCoursesNum; i++) {
        if (grades[i] < 65) {
            System.out.println("below 65 : " + i);// System.out.println : auto change line. no need \n.
        }

        if (grades[i] > 90) {
            System.out.println("above 90 : " + i);
        }
    }