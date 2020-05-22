String str = "4567895443577";
char[] chars = str.toCharArray();
HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
for( char c : chars )
{
    if( charMap.containsKey( c ) ){
        charMap.put(c, charMap.get(c) + 1 );
    }else{
        charMap.put(c, 1);
    }
}
for( Entry<Character, Integer> entry : charMap.entrySet() )
{
    System.out.println( "Character '"+entry.getKey()+"' is repeated for '"+entry.getValue()+"' times." );
}