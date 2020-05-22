A bbb = ...;
if (bbb instanceof B) {
    // bbb has been instantiated via B or one of B subclasses
} else {
    // bbb has been instantiated via A or one of A subclasses except B
}