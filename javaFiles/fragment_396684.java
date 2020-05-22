rule "Can I buy a beer?" when
    $p: Person()
    $bar: Bar( revellers contains $p )
    IsUnderAge( person == $p, country == $bar.country )
then
    insertLogical( new ThrowOutOfTheBar($p, $bar) );
end