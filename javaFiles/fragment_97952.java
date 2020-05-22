rule "stop if not met"
when
    // negated condition X
then
    drools.halt();
end