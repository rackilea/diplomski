if(bitString.length()%4!=0)
    System.out.println("Please Enter Valid Input.");
else
{
    for (int i = 0; i < bitString.length()/4; i++) 
    {
        String temp2 = bitString.substring(4*i,4*(i+1));
        for (int j = 0; j < binary.length; j++)
            {
            if (temp2.equalsIgnoreCase(binary[j]))
                {
                hexString = hexString + hex[j];
            }
        }
    }
    System.out.print("The equivalent hex string is ");
    System.out.println(hexString);
}