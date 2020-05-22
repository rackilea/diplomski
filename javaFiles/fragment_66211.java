public class Start {
    public static void main(String[] args){
        //Test String
        String s = "not4inc6desc3inc14";

        StringBuffer sb = new StringBuffer(s);

        //keep track where new word begins
        int newWord = 0;

        for(int i = 0; i < sb.length(); i++){

            //chekc if the new Character is a number
            if(checkNumber(sb.substring(i, i+1))){

                //if the old word ends with "inc"
                //maybe try out .contains()
                if(sb.substring(newWord, i).endsWith("inc")){
                    //replace number
                    StringBuffer temp = new StringBuffer();
                    int j  = 0;

                    //get full number
                    for(j = i; j < sb.length() && checkNumber(sb.substring(j, j+1)); j++){
                        temp.append(sb.substring(j, j+1));
                    }

                    //modify number
                    int number = Integer.parseInt(temp.toString()) + 1;

                    //replace number
                    sb.replace(i, i + temp.length(), Integer.toString(number));

                    //number no longer needs to be checked for being a word
                    i=j;
                }
            }
        }

        //print test String
        System.out.println(sb.toString());

    }

    // Check if String is numeric
    private static boolean checkNumber(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e ){
            return false;
        }
        return true;
    }
}