for(Object[] obj:list)
{
    byte ptext[] = (byte[])obj[0];
    String value = new String(ptext);
    System.out.println(obj[1]+" : "+value);
}