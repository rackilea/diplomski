private static final EnumSet<Human> DEAD_MAN = 
  EnumSet.of(Human.MAN, Human.DEAD);

public void doStuff(EnumSet human) {
    if ( human.containsAll( DEAD_MAN ) )
    {
            // do something
            break;
    }
    else
    {
        // more common cases
    }
}