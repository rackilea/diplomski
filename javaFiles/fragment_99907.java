int[] source = new int[1000];

int[] part1 = new int[500];
int[] part2 = new int[500];

//              (src   , src-offset  , dest , offset, count)
System.arraycopy(source, 0           , part1, 0     , part1.length);
System.arraycopy(source, part1.length, part2, 0     , part2.length);