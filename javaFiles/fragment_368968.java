String id;
    do{
        System.out.print("Please enter the student's ID?");            
        id = scan.next();
        if(id.matches("^-?[0-9]+(\\.[0-9]+)?$")){
            intStudentID=Integer.valueOf(id);
            break;
        }else{
            continue;
        }

   }while(true);