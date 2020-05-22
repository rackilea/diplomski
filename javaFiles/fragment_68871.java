private void run() {
        PersonData p = new PersonData();
        List<PersonType> personDetailsList = (List<PersonType>) p.getList();
        int input;
        boolean flag = false;
        try {
            do {
                Scanner in = new Scanner(System.in);
                System.out.println("Enter person ticket number");
                input = in.nextInt();
                for (PersonType q : personDetailsList) {
                    if (q.getPersonNumber() == input) {
                        System.out.println("Person Ticket Number: " + q.getPersonNumber() + "\n" 
                                + "Person Ticket Name: " + q.getPersonName() + "\n");
                        flag=true;                           
                        break;
                    }
                }
                if(!flag){
                    System.out.println("Wrong!!!");     
                }
            } while (input != -1);
            System.out.println("Bye");
        } catch (Exception e) {
            System.out.println(e);
        }
    }