OrderedDoublePair a = ...;
OrderedDoublePair b = a;  // a and b now refer to the same instance of OrderedDoublePair

...

if (a.equals(b)) {  // <---
    ...
}