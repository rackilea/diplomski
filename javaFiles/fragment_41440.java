public class LongestAlphabetDistance {

    public int longDistance(String str, String a) {
        str = "this is my greatest achivement in the world";
        a = "i";
        str = str.replaceAll("\\s", "");
        char[] chArray = str.toCharArray();
        ArrayList<Integer> inArray = new ArrayList<>();

        for(int i =0;i<chArray.length;i++) {
            if(chArray[i] == a.charAt(0) ) {
                inArray.add(i+1);
            }
        }

        return inArray.get(inArray.size()-1)-inArray.get(0); // 24 
    }
}