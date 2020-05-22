Predicate<Integer> gt10 = new GreaterThan(10);
Predicate<Integer> lt5 = new LessThan(5);

if(gt10.test(Parameter1)) then
    if(lt5.test(Parameter2)) then do A
    else do B
else do C