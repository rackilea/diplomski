int hash = 17;
hash = hash * 31 + srcadd.hashCode();
hash = hash * 31 + dstadd.hashCode();
hash = hash * 31 + sourceport; // I'm assuming this is an int...
hash = hash * 31 + destinationport; // ditto
hash = hash * 31 + protocol.hashCode();
return hash;