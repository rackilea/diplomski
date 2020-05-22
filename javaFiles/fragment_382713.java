if(opt==3){             
    System.out.println("Enter token num to delete");
    int to_num = sc.nextInt();
    Iterator<Student> itr = stdtQ.iterator();  

    while(itr.hasNext()){  
        Student obj = itr.next();
        if( obj.getTnum() == to_num)
        {
            stdtQ.remove(obj);
            break;
        }
    }       
 }