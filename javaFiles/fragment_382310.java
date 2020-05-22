public Student(String studentRecord){
    String strBirthDate;
    Scanner sc = new Scanner(studentRecord);
    sc.useDelimiter(";");

    try {
         adminNo = sc.next();
         name = sc.next();
         strBirthDate = sc.next();
         birthDate = MyCalendar.convertDate(strBirthDate.toString());
         test1 = sc.nextInt();
         test2 = sc.nextInt();
         test3 = sc.nextInt();
    } catch (NoSuchElementException exception)
        System.out.println("NoSuchElementException, the line was: " + studentRecord);
    }
}