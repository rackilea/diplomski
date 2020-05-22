The Same of your Codes but I Added The Stack  Hope you Understand it 
The implementation of stack :
Stack <String> stack = new Stack<String>();
stack.push(String);
stack.pop();

here is the  Same Example :

       Stack <String> stack = new Stack<String>();

    try
        {
        BufferedReader in = new BufferedReader(new FileReader("GoingThere.txt"));
        String line = in.readLine();
        String a,b,c,d;
        while(line != null)
        {
        System.out.println(a=line.replace("West","East"));
        System.out.println(b=line.replace("East","West"));
        System.out.println(c=line.replace("North", "South"));
        System.out.println(d=line.replace("South", "North"));

        stack.push(a);
        stack.push(b);
        stack.push(c);
        stack.push(d);    
        System.out.println("----------------- Stack Pushed -----------------");
        line = in.readLine();
        }
        System.out.println("Pop is Begin :");

        while(!stack.isEmpty()){

            System.out.println(stack.pop());
        }
        }

        catch(FileNotFoundException e)
        { 
          System.out.println("File Not Found"); 
        }
        catch(IOException e)
        { 
          System.out.println("IO Exception Found.");
        }