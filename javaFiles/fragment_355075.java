bMainMenu = true;
List<StudentInfo> students = new ArrayList<StudentInfo>();
while(bMainMenu){

    boolean bList = false;
    boolean bSearch = false;

    [all the code prompting choices]
                -if input is "create" then bList = true;
                -if input is "search" then bSearch = true;
                -if input is "exit" then bMainMenu = false;

    while(bList){
        [all the code that creates the array and prompts for student info
                     where the array is as long as the user chooses]

        // Build this student info object based on user parameters
        StudentInfo studentInfo = new StudentInfo(name, class);

        students.add(studentInfo);
    }

    while(bSearch){
        /*      
        Play with "students" arraylist. It is accessible here and contains all studentinfo details added before.
        */
    }
}