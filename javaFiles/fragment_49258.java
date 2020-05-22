int maxX = 10;
int scale = 5;
BigDecimal start = BigDecimal.valueOf( -maxX/2 );
BigDecimal end = BigDecimal.valueOf( maxX/2 );
BigDecimal step = BigDecimal.valueOf( 1.0/scale );
for( BigDecimal v = start; v.compareTo( end) <= 0; v = v.add( step ) ) 
{ 
  System.out.println("k:" + v.multiply( BigDecimal.valueOf( scale ) ).intValue() + "  " + v ); 
}