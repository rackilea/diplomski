public String indentFile() throws FileNotFoundException{
    LinkedList<Integer> positionBracket = new LinkedList<Integer>();
    String currentLine = "";
    Scanner indent = new Scanner(new FileReader(f));
    String stringIndented = "";

    while(indent.hasNextLine()) {

        currentLine =   indent.nextLine();
        currentLine = currentLine.trim(); 
        char[] lineInChar = currentLine.toCharArray();
        int i = 0;
        int spaceadded = 0;
        String space ="";
        if(!positionBracket.isEmpty()){

                while(spaceadded <= positionBracket.getFirst()){
                    spaceadded++; 
                    space += " "; // We put same space like the last opened bracket

                }

        }

        while(i < lineInChar.length){

            if(lineInChar[i] == '('){ //If opened bracket I put the position in the top of the Filo


                positionBracket.addFirst(new Integer(i));

            }
            if(lineInChar[i] == ')' && !countCom){
                positionBracket.removeFirst(); //If closed bracket I remove the position on the top of the Filo

            }



            i++;
        }
        stringIndented += space + currentLine +"\n";
        }
    }
    return stringIndented;

}