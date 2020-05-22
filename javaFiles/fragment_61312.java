public Student(String record) {
    Scanner sc = new Scanner(record);
    sc.useDelimiter(";");
    adminNo = sc.next();
    name = sc.next();
    birthDate = MyCalendar.convertDate(sc.next());
    test1 = sc.nextInt();
    test2 = sc.nextInt();
    test3 = sc.nextInt();
}