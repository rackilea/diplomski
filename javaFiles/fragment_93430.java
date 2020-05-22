rule "check if inside array"
when
    Colors($a: myColors, $b: colorArray )
    eval( cardInter( $a, $b ) > 1 )
then
    System.out.println( "Color found more than once" );
end