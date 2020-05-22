rule "Determine person effective date"
    when
        $person : Person($date1 : date1)
    then
        // do the desired calculation
        Date $effectiveDate = $date1.plusDays(3);
        PersonEffectiveDate ped = new PersonEffectiveDate($person, $effectiveDate);
        insert(ped);
end

rule "TimeComparison"
    when
        PersonEffectiveDate($person : person, $effectiveDate : effectiveDate >= date2)
    then
        //
end