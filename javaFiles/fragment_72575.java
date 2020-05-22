if (UserID == EnteredUserID && (Password == EnteredPassword) 
                && (StudentNumber == EnteredStudentNumber)) {
            System.out.println("Athentication complete!");
            System.out.println("***Elevator access granted!***");
            System.out.println("Welcome...");
            Elevator a = new Elevator(); //actually do something
            Elevator.selectfloor();
            break;
        }