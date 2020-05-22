case 4: if(studentInfo.isEmpty())
        {
            System.out.println("No student record exists!");
        }
        else
        {
            System.out.println("Enter the name of the student you want to search for: ")
                    searchName = sc2.next();
                    int i = 0;

                    for(Student stu : studentInfo)
                    {
                       if(stu.getName().equalsIgnoreCase(searchName))
                        {
                           System.out.println("Match found: "+stu);
                           i++;

                        }
                     }
                     if(i == 0)
                         System.out.println("No Match found");
        }
        break;