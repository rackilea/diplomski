Student[] students = new Student[5];

for (int counter=0; counter< 5; counter++)
        {

            System.out.println("Enter name for student " + counter);
            String name = scanner.nextLine();
            System.out.println("Enter course for student " + counter);
            String course = scanner.nextLine();
            System.out.println("Enter mark for student " + counter);
            String mark = scanner.nextLine();
            System.out.println("Enter number for student " + counter);
            String number = scanner.nextLine();

            Student student = new Student(name, course, mark, number);

            students[counter] = student;

        }

for (int counter=0; counter< students.length; counter++)
        {
           students[counter].display();

        }