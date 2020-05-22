int i = 0; // your counter, now defined outside of the loop -- but still usable inside
for ( SomeItem e : SomeIterableObj ) { // the for-each loop
    // do something with the element, 'e'
    // do something with the counter, 'i'
    i++; // or manipulate the counter in whichever way you need to.
}