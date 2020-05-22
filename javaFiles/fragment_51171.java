do {
        Student student = new Student();
        System.out.println("Add Records");

        System.out.print("Name: ");
        student.setName(scanz.nextLine());

        System.out.print("Course: ");
        student.setCourse(scanz.nextLine());

        System.out.print("Gender: ");
        student.setGender(scanz.nextLine());

        System.out.print("School: ");
        student.setSchool(scanz.nextLine());

        // Add student to students ArrayList
        students.add(student);

        System.out.println("Another?\n1.Yes\n2.No");
        adds = scanz.nextLine();
        addagain = Integer.parseInt(adds);
    } while (addagain == 1);