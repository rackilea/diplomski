import java.util.Scanner;

class File_Scanner{    
    public static void read(){
        try {
            File credentials_file = new File("credentials.txt");
            Scanner file_reader = new Scanner(credentials_file);
            String[] users = new String[6];
            int index_counter = 0;

            while (file_reader.hasNextLine()) {
                users[index_counter] = file_reader.nextLine();
            }

            file_reader.close();
        } catch (Exception e) {
          System.out.println(e.getClass());
        }
    }
}