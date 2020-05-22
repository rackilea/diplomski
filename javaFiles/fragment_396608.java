// number of Athletes you want
    Athlete[] eAthlete = new Athlete[5];
    // Name of each athlete
    String[] names = { "ss", "aa", "bb", "cc", "xx" };

    // On each iteration, the name of the Athlete
    // and his/her grade is set,

    Scanner in = new Scanner(System.in);
    for (int i = 0; i < eAthlete.length; i++) {
        eAthlete[i] = new Athlete();
        eAthlete[i].setName(names[i]);
        System.out.println("Please enter Grade for: "
                + eAthlete[i].getName());
        eAthlete[i].setGrade(in.nextLine());
    }

    in.close();

    // Print all athletes with their grades,
    System.out.println("Before Sorting");
    for (Athlete s : eAthlete) {
        System.out.println(s.getName() + " " + s.getGrade());
    }