rule "test pending cart item"
when
    //conditions
    $cart : CartObj( $status == "pending")
then
    //actions
    System.out.println("\nPrint Pending Items Rule");
end