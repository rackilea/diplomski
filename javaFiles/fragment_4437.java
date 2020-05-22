List<String> classesList = new ArrayList<String>();
classesList.add("mage");
classesList.add("warrior");
classesList.add("thief"); 

Scanner input = new Scanner(System.in);

String input = input.next();
boolean isExist = false;
for (String item : classesList) { 
    if (input.equals(classesList.get(counter))) {
        //Your logic if it's there.
         isExist = true;
         break;
   }
}

 if(isExist) {
     //Found in the arraylist.
 }