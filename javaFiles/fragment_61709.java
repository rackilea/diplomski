public class YourClassName{

       static boolean isAnswerSelected = false;

       //your codes goes here

       Answer1.setHorizontalAlignment(SwingConstants.LEFT); 
       Answer1.addActionListener(new ActionListener() { 

         public void actionPerformed(ActionEvent e) { 

             if(!isAnswerSelected){  //this line will check whether an answer is already selected
                  isAnswerSelected = true;   // this will make other answers unselectable
                  Answer1.setBackground(Color.BLUE); 
                  Answer1.setForeground(Color.WHITE); 
             }
         } 
       });

   }