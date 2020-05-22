try 
  {
     output=new BufferedOutputStream(Files.newOutputStream(file));
      writer= new BufferedWriter(new OutputStreamWriter(output));

     System.out.println("Enter ID number or 999 to quit");

     id=in.nextLine();

     while (!id.equals("999"))
     {
        System.out.println("Enter first name");
        firstName=in.nextLine();
        System.out.println("Enter last name");
        lastName=in.nextLine();

        s=id+","+firstName+","+lastName+System.getProperty("line.separator");
        writer.write(s,0,s.length());

        System.out.println("Enter id number or 999 to quit: ");
        id=in.nextLine();
     }
    writer.close();

  }
  catch(Exception e)
  {
     System.out.println("Error: "+e);
  }