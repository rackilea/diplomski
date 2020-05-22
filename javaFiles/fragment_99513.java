while (true) {

    int i;

    for (i = 0; i < MAX_ATTEMPT && !try_something(); ++ i)
        ;
    if (i == MAX_ATTEMPT)
        continue;

    for (i = 0; i < MAX_ATTEMPT && !try_next_thing(); ++ i)
        ;
    if (i == MAX_ATTEMPT)
        continue;

    // etc.

}