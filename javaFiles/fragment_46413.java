StringBuffer sb = new StringBuffer();
sb.append(user);
sb.append(" : ");
for(int i = 3; i < parts.length; i++)
{
     sb.append(parts[i]);
     if(i < parts.length-1) //if you don't want a space after the last part
     {
         sb.append(" ");
     }
}
String formattedOutput = sb.toString();
System.out.println(formattedOutput);