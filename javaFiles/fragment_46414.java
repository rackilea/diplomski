StringBuffer sb = new StringBuffer();
    sb.append(user);
    sb.append(" : ");
    appendFromArray(sb, parts, 3);
    String formattedOutput = sb.toString();
    System.out.println(formattedOutput);
}

private void appendFromArray(StringBuffer sb, String[] array, int index)
{
    for(int i = index; i < array.length; i++)
    {
         sb.append(array[i]);
         if(i < array.length-1) //if you don't want a space after the last part
         {
             sb.append(" ");
         }
    }
}