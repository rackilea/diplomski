declare AgeLimit
    country: String
    age: int
end
declare Bar
    country: String
    revellers: java.util.Collection
end
declare Person
    age: int
end
declare ThrowOutOfTheBar
    person: Person
    bar: Bar
end

rule "UK drinking age" salience 1000 when then
    insertLogical( new AgeLimit( 'uk', 18 ) );
end
rule "US drinking age" salience 1000 when then
    insertLogical( new AgeLimit( 'us', 21 ) );
end

rule "Can I buy a beer?" when
    $p: Person()
    $bar: Bar( revellers contains $p )
    AgeLimit( country == $bar.country, age > $p.age )
then
    insertLogical( new ThrowOutOfTheBar($p, $bar) );
end