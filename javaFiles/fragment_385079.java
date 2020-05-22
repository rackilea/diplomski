char[] chars = new char[]{ 'a', 'b', 'c', ..., 'z' };
Alphabet lower = new Alphabet( chars );

for( int i = 0; i < chars.length; i++ ) {
  chars[i] = Character.toUpperCase( chars[i] );
}
Alphabet upper = new Alphabet( chars );