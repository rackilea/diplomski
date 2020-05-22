//I'm assuming alphashuff is a char[]
List<Character> lstCh = new ArrayList<Character>();
for(char c : arrCh) {
    lstCh.add(c);
}
Collections.shuffle(lstCh);
//...
else
{
    output = output + lstCh.get(n);
}