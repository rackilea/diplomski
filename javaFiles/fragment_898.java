if (current value == 1 && zeroCount < 2)
  add to current split
  zeroCount = 0
else if (current value == 1) // after 00...
  if (zeroCount % 2 == 1) { add zero to current split; zeroCount--; }
  record current split, clear current split
  while (zeroCount > 2) { record 0-distance split; zeroCount -= 2; }
else zeroCount++