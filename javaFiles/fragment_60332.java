char[] temp = string.toCharArray(); 
String reassembled = "";
for(int a = 0;a<temp.length;a++)
{
    reassembled+=temp[a]+"\n";    //Adding newline
}
System.out.print(reassembled);