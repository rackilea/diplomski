public class Main {
        public static void main(String[] args) {
             EmployeeStore employee = new EmployeeStore();

            try {

                    Employee str = new Employee("Akram","Khalifa");
                    employee.ajouter(str);
                    StringBuilder  stringBuilder = new StringBuilder();
                    stringBuilder.append( "firstName : "+str.getFirstName () + " --LastName :"+str.getLastName());
                    FileWriter writer = new FileWriter("C:/Users/Akram/Documents/akram.txt") ;
//write down ur employee in the file 
                    writer.write(stringBuilder.toString());;
                    BufferedWriter out = new BufferedWriter(writer) ;

                    out.close();
                    System.out.println("File created successfuly");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

         }
    }