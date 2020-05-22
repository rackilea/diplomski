StringBuilder sb = new StringBuilder();
for(int i = 0; i < splitted.length;i++)
{
    sb.append(splitted[i]);
    if(i == 2)
    {
        break;
    }   
}
String newS = sb.toString();