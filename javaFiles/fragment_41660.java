List<StudentRecord> studentRecords = new ArrayList<StudentRecord>();
    while(input.hasNext())
    {
        id=input.nextInt();
        last=input.next();
        first=input.next();
        year=input.nextInt();
        StudentRecord record = new StudentRecord(id, last, first, year);
        studentRecords.Add(record);
        System.out.println(id + "  " + last + "  " + first + "  " + year + "\n");

    }