for(z=0 ; z<no ; z++)
{
    String s = in.nextLine(); 
    arr[z] = new char[s.length()];
    for( y =0 ; y<s.length() ; y++)
    {
        arr[z][y]=s.charAt(y);
    }
}