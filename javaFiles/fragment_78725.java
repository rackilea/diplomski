private static String ConvertColumnNumberToChars( int i ){

if( i < 0 )
throw new UnsupportedOperationException("Converted number must be greater than zero.");

int iBase = 'Z' - 'A'+1;
if( iBase > Character.MAX_RADIX )
throw new UnsupportedOperationException("This JRE can't convert to radix greater than "+Character.MAX_RADIX);

String interConversion = Integer.toString(i-1, iBase).toUpperCase();

//System.out.print("inter: "+ interConversion +";  ");

char[] ac = interConversion.toCharArray();

for( int j = 0; j < ac.length; j++ ) {

int poziceOdzadu = ac.length - j - 1;
char c = ac[j];
ac[j] =  (char) ('A' - poziceOdzadu + Character.digit( c, iBase ));

}
return String.copyValueOf( ac );

}