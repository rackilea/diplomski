rule "oldest child"
when
  Person($pn: name, $pd: dateOfBirth, $children: children)
  Person($ocn: name) from accumulate(
    $child: Person( $cd: dateOfBirth) from $children,        
    init( Person minp = null; Date mind = new Date(); ),
    action( if( $cd.compareTo( mind ) < 0 ){
                minp = $child;
                mind = $cd;
            } ),
    result( minp ) )
then
  System.out.println( $pn + "'s oldest child is " + $ocn );
end