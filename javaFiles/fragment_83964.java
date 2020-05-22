public static void main(String[] args) throws JAXBException {

    //get the data from the database as is
    OracleConnection myOracleConnection = new OracleConnection(ORACLE_DRIVER, ORACLE_CONN);
    List<DbStudent> dbStudentList = null;
    try {
        dbStudentList = myOracleConnection.getStudents(); //get the list of students from the procedure or query
        myOracleConnection.CloseConnection();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Stopping execution and exiting...");
        System.exit(-1);
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Stopping execution and exiting...");
        System.exit(-1);
    }

    //sort the list on Id, so we can know when we find a new student
    Collections.sort(dbStudentList, new Comparator<DbStudent>() {
            public int compare(DbStudent s1, DbStudent s2) {
                return s1.getId().compareTo(s2.getId());
            }
        });

    List<Student> studentList=new ArrayList<Student>(); //list which will hold all the student objects

    Integer previousId = 0; //control variable
    List<ScoreRecord> marksList = new ArrayList<ScoreRecord>(); //list to store the marks for each student        
    Student s = null;

    for (int i=0;i<dbStudentList.size();i++) {

        if(i==dbStudentList.size()-1){ //if we reached the end, no more students after this record, set the marks and add the student to the list
            s.setScoreRecords(marksList);
            studentList.add(s);
        }

        if (dbStudentList.get(i).getId().compareTo(previousId) != 0) {
            //new student found
            if(s!=null){
                //if new student found add the previous one to the list after setting the marks
                s.setScoreRecords(marksList); 
                studentList.add(s);
            }
            s = new Student(); //create a new student
            s.setFirstName(dbStudentList.get(i).getFirstName());
            s.setId(dbStudentList.get(i).getId());
            s.setLastName(dbStudentList.get(i).getLastName());

            ScoreRecord sr = new ScoreRecord();
            sr.setSub(dbStudentList.get(i).getSub());
            sr.setPercent(dbStudentList.get(i).getPercent());

            marksList = new ArrayList<ScoreRecord>(); //reset marks list
            marksList.add(sr);
        } else {
            //same student
            ScoreRecord sr = new ScoreRecord();
            sr.setSub(dbStudentList.get(i).getSub());
            sr.setPercent(dbStudentList.get(i).getPercent());
            marksList.add(sr); //add mark to existing marks list
        }
        previousId=dbStudentList.get(i).getId(); //set the control variable to the new id
    }

    StudentGroup sg=new StudentGroup(); //create the student wrapper
    sg.setStudents(studentList); //add the student list to the wrapper

    //create xml with JAXB
    JAXBContext context = JAXBContext.newInstance(StudentGroup.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    m.marshal(sg, new File(STUDENT_XML));
}