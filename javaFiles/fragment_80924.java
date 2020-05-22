// we just insert Customer objects in the WM

rule "evaluateRetired"
when
    $c : Customer(age > 65)
then
    insertLogical(new Retiree($c));
end

rule "evaluteRetireeIsFemale"
when
    $r : Retiree(customer.gender == Gender.FEMALE, $c : customer)
then
    ...
end