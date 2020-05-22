public static void main(String[] args)
{
Scanner kbd = new Scanner(System.in);
        System.out.println("Please enter any String: ");
        String myString = kbd.nextLine();
        char[] myArray = myString.toCharArray();
        boolean result = false;

        for(int i = 0; i < myArray.length; i++)
        {
            if(myArray[i] == 'a' && myArray[i+4] == 'b'){
                result = true;
                break;
            }
        }
        System.out.println(result);

}