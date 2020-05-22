String userInput = //get user's input
while(!userInput.equalsIgnoreCase("ListLayout") && !userInput.equalsIgnoreCase("gridLayout")){
   System.out.println("Please enter a valid option");
   userInput = //get user's input again
}
CustomLayout layout;
if(userInput.equalsIgnoreCase("ListLayout")
   layout = new ListLayout();
else
   layout = new GridLayout();