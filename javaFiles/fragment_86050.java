rule "Your First Rule"
when
    $testRule : TestRule(count >= 100)
    not         Flag(id="packets")
then 
    System.out.println("100 PACKETS");
    insert( new Flag("packets") )
    update( $testRule )
end