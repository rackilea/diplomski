public void <X1, X2> doTheThing(X1 set1, X2 set2)
{
    Logic logic = new Logic<X1, X2, A>();
    for (SomeClass<X1, A> t1 : set1) {
        logic.setT1(t1);
        if(set2.isEmpty())
            logic.apply();
        else
            for (SomeClass<S2,A> t2 : set2) {
                logic.setT2(t2);
                logic.apply();
            }
    }
}