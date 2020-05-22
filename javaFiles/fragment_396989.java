Base foo = new Base();

/* After execution:
 *
 * Vars:   | Objects:
 * foo ----+---> a Base object (Name: Joe)
 */

foo = foo.becomeDerived();

/* After execution:
 *
 * Vars:   | Objects:
 * foo ----+---> a Derived object (Name: Phil)
 *         |     a Base object (Name: Joe)(notice nothing references it)
 */