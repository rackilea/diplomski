System.out.println("Please enter your Studentid");

        Scanner studentid= new Scanner(System.in);

        int stdnumber = studentid.nextInt();

        studentid.nextLine();

        Scanner name = new Scanner(System.in);

        System.out.println("Please enter your first name:"); 

    while(!name.hasNext("[a-zA-Z]+")){  
        System.out.println("Please re-enter your name, use alphabets only");
        System.out.println("Please enter your first name:");
        name.nextLine();                        
        }

    String firstname=name.nextLine();   

    System.out.println("Your Updated firstname is " + firstname);

    //Connection to db
    try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_db","root","admin");

        Statement stmt = (Statement) conn.createStatement();

        String update = "UPDATE `student_db`.`studentinfo` SET `Student_FirstName`='"+firstname+"' WHERE `Student_ID`='"+stdnumber+"' ";

        int rs= stmt.executeUpdate(update);

        }catch (Exception e){
            System.err.println(e);
        }