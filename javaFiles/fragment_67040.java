try (PrintWriter output = 
         new PrintWriter(new BufferedWriter(new FileWriter("Sign_in.txt")))) 
{            
    for (String line: list) {
        output.println(line);
    }

} catch (Exception e) {
    e.printStackTrace();
}