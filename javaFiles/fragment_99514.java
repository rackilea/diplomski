boolean doFirstThing () {
    int i;
    for (i = 0; i < MAX_ATTEMPTS && !try_something(); ++ i)
        ;
    return i < MAX_ATTEMPTS;
}

boolean doSecondThing () {
    int i;
    for (i = 0; i < MAX_ATTEMPTS && !try_other_thing(); ++ i)
        ;
    return i < MAX_ATTEMPTS;
}

// then, elsewhere
while (true)
    doFirstThing() && doSecondThing();