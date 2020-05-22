public static void main(String[] args) {

    //3 students for reading 9 lines
    //Susan,  Jurgen and You ;)
    Student[] students = new Student[3];

    int linesRead = 0;

    String aLine = null;

    // read each line through aLine
    for (Student student : students) {

        //use buffered/scanner classes for reading input(each line) in aLine
        while (aLine != null) {
            ++linesRead;
            if (linesRead == 1) {
                student.setNoOfCases(Integer.valueOf(aLine));
                ++linesRead;
            } else if (linesRead == 2) {
                student.setWorkSchedule(Arrays.asList(aLine.split(" ")));
                ++linesRead;
            } else if (linesRead == 3) {
                student.setInitialTV(Arrays.asList(aLine.split(" ")));
            } else {
                linesRead = 0;
            }
        }
    }
}
}