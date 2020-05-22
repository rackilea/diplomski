ArrayList list = new ArrayList();


    do  {
       System.out.print("Enter your text :");
       input=sc.nextLine();
       list.add(input);
       count++;
       }

   while (!input.equals("#"));
{
       System.out.print("Result :\n");

       strResult = "Case #"+(count-1)+" :"+input;
       //result[count] = strResult;<<<<<<to represent all result
       }       

   for (i=0;i<list.size()-1;i++) {

       System.out.println("Case #" +  (i+1) + " " + list.get(i));

   }