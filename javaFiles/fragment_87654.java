public class InputSelect {

    public static final String[] colleges = { "College-1", "College-2", "College-3", "College-4" };

    public static final String[][] dept = {{"college-1 Department-1","college-1 Department-2"},{"college-2 Department-1","college-2 Department-2"},{"college-3 Department-1","college-3 Department-2"},{"college-4 Department-1","college-4 Department-2"}};

      public static void main(String[] args)
      {

        JFrame frame = new JFrame("Input Dialog Example 3");
        String favoritecollege = (String) JOptionPane.showInputDialog(frame, 
            "Select Your Choice Colleges : ",
            "Choose College",
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            colleges, 
            colleges[0]);

        int index = 0;

        for(String clg : colleges){
            if(favoritecollege.equals(clg)){
                break;
            }else{
                index++;
            }
        }

        String favouriteDept = (String) JOptionPane.showInputDialog(frame, 
                "Select Your Choice Department : ",
                "Choose Dept of "+ favoritecollege +" college : ",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                dept[index], 
                dept[index][0]);

        System.out.printf("Favorite College is %s.\n", favoritecollege);
        System.out.printf("Favorite Dept is %s.\n", favouriteDept);


      }

}