Files.deleteIfExists("C:\\Users\\HP\\Desktop\\STUD_INFO.txt"); //deletes the file

FileWriter fw=new FileWriter("C:\\Users\\HP\\Desktop\\STUD_INFO.txt" , true);
PrintWriter pw=new PrintWriter (fw);
pw.println("\t\t\t\t\t\tSTUDENT INFORMATION");
pw.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
pw.println("First_Name" + "\t\t    " + "Last_Name" + "\t\t    " + "Address" + "\t\t    " + "E_mail" + "\t\t    " + "Department" + "\t\t    " + "Password");
pw.println(First_Name   + "\t\t\t    " + Last_Name + "\t\t    " + Address + "\t\t    " + E_mail + "\t    " + Department + "\t\t\t    " + Password);  
pw.close();