// first outcome processor (an instance of `OutcomeProcessor1` needs 'a' and 'c' input parameters
ourMap.put(0x5, new OutcomeProcessor1());

// second outcome processor (needs 'a' and 'd')
ourMap.put(0x9, new OutcomeProcessor2());

// so you'll see that if the input is 'a','c' and 'd' then both processors
// are invoked.

// repeat for all possible outcome processors