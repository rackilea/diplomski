public static boolean matchingChar(final String st1, final String st2) {

        if(st1 == null || st2 == null || st1.length() < 5  || st2.length() < 5) {
            return false;
        } 

        //This is if you wish unique characters to be counted only
        //Otherwise you can use simple int count = 0
        HashSet<Character> found = new HashSet<Character>();

        //found.size() < 5 so the loop break as soon as the condition is met
        for(int i = 0; i < st1.length() && found.size() < 5; i++) {         
            if(st2.indexOf(st1.charAt(i)) != -1) {
                found.add(st1.charAt(i));
            }
        }

        return found.size() >= 5;
    }