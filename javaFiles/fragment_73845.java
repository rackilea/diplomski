public class SearchProp {
     public String getSearchCriteria()
     {
            Scanner user = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println("Please enter your Search: ");
            input = user.next();
     }

     public void Search(String input) throws FileNotFoundException{
        try{
            String details, id, line;
            int count;
            Scanner housenumber = new Scanner(new File("writeto.txt"));
            while(housenumber.hasNext())
            {
                id = housenumber.next();
                line = housenumber.nextLine();
                if(input.equals(id))
                {
                    JOptionPane.showMessageDialog(null,id + line );
                    break;
                }
                if(!housenumber.hasNext())      
                     System.out.println("No Properties with this criteria");
            }
       }

       catch(IOException e)
       {
            System.out.print("File failure");
       }
   }
}