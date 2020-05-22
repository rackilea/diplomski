static final int FLAG0 = 1;
static final int FLAG1 = 1 << 1;

final AtomicInteger intFlags = new AtomicInteger(FLAG0);

void somewhere() {
    int flags = intFlags.get();

    int both = FLAG0 | FLAG1;
    if((flags & both) == FLAG0) { // if FLAG0 has a 1 and FLAG1 has a 0
        something();
    }

    flags &= ~FLAG0; // set FLAG0 to 0 (false)
    flags |=  FLAG1; // set FLAG1 to 1 (true)

    intFlags.set(flags);
}