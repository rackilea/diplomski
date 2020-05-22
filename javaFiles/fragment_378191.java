final String input = "<span class=\"b\"><a href=\"/paline/linea/014?id_palina=76954&amp;nav=5#pal\">014</a>:</span>";

final int i2 = input.lastIndexOf( "</a>" );
final int i1 = input.lastIndexOf( '>', i2 ) + 1;

final String result = input.substring( i1, i2 );

System.out.println( result );