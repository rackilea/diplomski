byte low = Byte.valueOf("01111111", 2); // The maximum byte value
byte high = low; // This copies low.

byte sum = low + high; // The bit representation of this is 11111110, which, having a
                       // leading 1, is negative. Consider this the worst case
                       // overflow, since low and high can't be any larger.

byte mid = sum >>> 1; // This correctly gives us 01111111, fixing the overflow.