class AlreadyDefined // begin class scope
{
    static int y = 0; // Defining variable with identical name.

    public static void main(String[] args){ // begin method scope

        for(int i = 0; i < 5; i++){ // begin loop scope
            int y = i; // This still works
            System.out.println(i);
        } // end loop scope

    } // end method scope

} // end class scope