synchronized(o) {
    while (! IsConditionTrue()) {
        o.wait();
    }
    DoSomethingThatOnlyMakesSenseWhenConditionIsTrue_and_MaybeMakeConditionFalseAgain();
}