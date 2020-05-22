public class Experiments {  
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File file = new File("/Users/Username/Location/Contacts.txt"); //change to location of your file
        Scanner reader = new Scanner(file);

        String[][] users = {reader.nextLine().split(" - "), reader.nextLine().split(" - "), reader.nextLine().split(" - ")};
        boolean validUserName = false;
        while (!validUserName) { 
            System.out.println("Enter your User name.");
            String userName = input.next();
            for(int i = 0; i < users.length; i++){
                for(int j = 0; j < users[i].length; j++){
                    if (users[i][0].equalsIgnoreCase(userName)){
                        System.out.println("INFO FOR: " + users[i][0]);
                        System.out.println("IME: " + users[i][1]);
                        System.out.println("PREZIME: " + users[i][2]);
                        System.out.println("BROJ: " + users[i][3]);
                        System.out.println("EMAIL: " + users[i][4]);
                        validUserName = true;
                        break;
                    }
                }
            }
            if(!validUserName){
                System.out.println("Invalid User name. Please try again.");
            }
        }
        input.close();
        reader.close();
    }
}