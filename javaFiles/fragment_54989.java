boolean found=false;
    while ((findNameOriginal = reader.nextLine()) != null)
      {
         Scanner nameLine = new Scanner(findNameOriginal);
         space = findNameOriginal.indexOf(" ");
         findName = nameLine.next();            
         for (year = 1900; year <= 2000; year += 10)
         {
            rank = nameLine.nextInt();        
            if (findName.equalsIgnoreCase(name))
            {
               System.out.println(year + ": " + rank);
               found=true;
            }


         }

      }  
if(!found) System.out.println("Name not found");