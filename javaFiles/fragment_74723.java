String enteredGrade = "";
            while(enteredGrade.length()!=1) {
                System.out.print("Enter grade:");
                enteredGrade = input.nextLine();
                if(enteredGrade.length()==1) {
                    grade = enteredGrade.charAt(0);
                } else {
                    System.out.println("Type only one character!");
                }
            }