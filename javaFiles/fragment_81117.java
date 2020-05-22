rule "find same name and age"
when
    $p1: Person( $name: name, $age: age, status == false )
    $p2: Person( name == name, age == $age, status == false, this != $p1 )
    accumulate( $p: Person( name == name, age == $age, status == false );
                $list: collectList( $p ) )
then
    for( int i = 0; i < $list.size(); i++ ){
        Person p = (Person)$list.get(i);
        update( p ){ setStatus( true ) }
    }
end