public boolean isUniqueChars(String str){

   //more than 256 chars means at least one is not unique
   //please see first comment by @Domagoj as to why 256 length
    if(str.length()>256) return false;  

        //keeping an array to see which chars have been used
        boolean[] char_set = new boolean[256];

        //iterating over the string
        for(int i=0; i<str,length;i++){

            //not sure what language this is, but let's say it returns an
            //int representation of the char
            int val=str.charAt(i);

            //meaning this has been set to true before, so this char is not unique
            if(char_set[val]) 
                //nope, not unique
                return false;

            //remember this char for next time
            char_set[val]=true;
        } 

    //if we reached here, then string is unique
    return true;
}