class AlreadyDefined // begin class scope
{

    public static void main(String[] args){ // begin method scope

        for(int i = 0; i < 5; i++){ // begin loop scope. 
            /// This scope also includes variables from method scope
            int y = i; 
            System.out.println(i);
        } // end loop scope

    } // end method scope

} // end class scope