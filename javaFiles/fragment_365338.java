System.out.println(DataType.connectPlayer.build("first", "second"));
System.out.println(DataType.returnServerState.build("first", "second", "...", "more"));

// prints:
// connectPlayer:first:second
// returnServierStateArgs [first, second, ..., more]