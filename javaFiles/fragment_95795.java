MyType mt = ...;

if (mt.isObjectActive()) {
    // This is broken because there's no guarantee that mt still will be "active"
    // by the time doSomething...() gets called.
    //
    doSomethingThatOnlyMakesSenseWhen_mt_IsActive(...);
}