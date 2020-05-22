public class help
    {
        public static void main(String[] args)
        {
            System.out.print(isAllVowels("aseiou".toLowerCase()));
        }
        public static boolean isAllVowels(String Str)
        {
        if( Str.length() == 0)
        {
            return true;
        }
        for( int a=0; a<Str.length(); a++)
        {
            char c = Str.charAt(a);
            if(c=='a' || c=='e' || c =='i' || c=='o' || c=='u')
            {
                continue;
            }
            else  return false;

        }
        return true;
    }
}