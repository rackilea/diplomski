System.out.println("Name of dog:");
            String userInput3 = myscan.next();

            for(Dog d : doglist) 
            {
                if(d.getName().equals(userInput3)) 
                {
                    doglist.remove(d.toString());
                }
                else
                {
                    System.out.println("Can't find dog");
                }
            }

            break;