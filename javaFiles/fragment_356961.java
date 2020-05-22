public class ReplaceChar {

    public static void main(String... args){
        String[] input =new String[]{"ababba","anaceeacdabnanbag","aabaaaavfaajaaj"};

        StringBuilder result = new StringBuilder();

        for (int i= 0; i < input.length;i++){
            result.append(getReplacedA(input[i]));
            result.append("\n");
        }

        System.out.println(result);

    }

    private static String getReplacedA(String withA){
        // stringBuilder for result
        StringBuilder replacedString = new StringBuilder();

        // counting the number of time char 'a' occurred in String for replacement before row of 'aaa'
        int charACount = 0;

        // get the first index at which more than two 'aa' occurred in a row
        int firstIndexOfAAA = withA.indexOf("aaa") + 1;

        // if 'aaa' not occurred no need to add the rest substring
        boolean addSubRequired = false;

        // if the index is 0 continue till end
        if (firstIndexOfAAA == 0)
            firstIndexOfAAA = withA.length();
        else
            addSubRequired = true;

        char[] charString = withA.toCharArray();

        //Replace character String[] array
        String[] replace = new String[]{"x","xx","xxx"};

        for(int i = 0; i < firstIndexOfAAA; i++){
                if (charString[i] == 'a'){
                    charACount++;
                charACount = charACount > 3 ? 1 : charACount ;
                // add the number x based on charCount
                replacedString.append(replace[charACount - 1]);
                }else{
                    replacedString.append(charString[i]);
                }
        }

        // if the String 'aaa' has been found previously add the remaining subString
        // after that index
        if (addSubRequired)
            replacedString.append(withA.substring(firstIndexOfAAA));

        // return the result
        return replacedString.toString();
    }

}