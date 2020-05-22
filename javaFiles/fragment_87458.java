public class WordTransformer {

    private HashMap<Character, char[]> transformMap = new HashMap<Character, char[]>();
    {
        transformMap.put('h', new char[]{'H', 'h'});
        transformMap.put('e', new char[]{'3', 'E'});
        transformMap.put('l', new char[]{'I', 'L'});
        transformMap.put('o', new char[]{'0', 'O'});
    }

    public List<String> doTransform(String s){
        char[] stringChars = s.toCharArray();
        List<String> versions = new ArrayList<String>();
        doTransform(s, stringChars, 0, versions);
        return versions;
    }

    //This method is recursive
    private void doTransform(String s, char[] stringChars, int index,
        List<String> versions){

        //if we reached the end of string in current iteration
        //add generated variant into list
        if(index==s.length()){
            versions.add(new String(stringChars));
            return;
        }

        char c = s.charAt(index);
        if(transformMap.containsKey(c)){
            char[] transforms = transformMap.get(c);
            for(char t : transforms){
                stringChars[index] = t;
                //And this is recursive invocation, that means method calls itself
                doTransform(s, stringChars, index+1, versions);
            }
        }else {
            //if there is no such character in transform map, process next index
            doTransform(s, stringChars, index+1, versions);
        }
    }

}