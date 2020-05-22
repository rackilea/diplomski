boolean doLoop = true;
Graduate grad = null;

while(doLoop) {
        System.out.println("Is student a TA? (1: YES 0: NO): ");
        status = inReader.nextInt();

        if (status == 1) {
            grad = new Graduate(studentID, name, major, true);
            doLoop  = false;
        }
        else if (status == 0) {
            grad = new Graduate(studentID, name, major, false);
            doLoop  = false;
        }
        else {
            System.out.println("Please enter valid entry.");
        } 

        if (grad != null){
            grad.displayStudentData();
        }
    }
}