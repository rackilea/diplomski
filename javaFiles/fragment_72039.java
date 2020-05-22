@Override
public int compare(String s1, String s2) {

// Returns a negative integer, zero, or a positive integer 
// as the first argument is less than, equal to, or greater than the second.

                if(s1.length() == 0 && s2.length() > 0)return 1; 
                if(s2.length() == 0 && s1.length() > 0)return -1; 
                if(s2.length() == 0 && s1.length() == 0)return 0; 

                return (s1.charAt(s1.length()-1) - s2.charAt(s2.length()-1));
            }