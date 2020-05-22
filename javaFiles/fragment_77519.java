Lambda<int,int> array[10] = new Lambda<int,int>[10]();
 for (int i = 0; i < 10; ++i ) {
    array[i] = new Lambda<int,int>{ final int multiplier = i;
       int exec( int x ) { return x * multiplier; }
    };
 }
 // note this is disallowed in the current proposal, as `i` is
 // not effectively final and as such cannot be 'captured'. Also
 // if `i` was marked @Shared, then all the lambdas would share
 // the same `i` as the loop and thus would produce the same
 // result: multiply by 10 --probably quite unexpectedly.
 //
 // I am aware that this can be rewritten as:
 // for (int ii = 0; ii < 10; ++ii ) { final int i = ii; ...
 //
 // but that is not simplifying the system, just pushing the
 // complexity outside of the lambda.