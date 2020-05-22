int[] result = fact(50);
int i = result.length - 1;
while (i > 0 && result[i] == 0)
    --i;
while (i >= 0)
    System.out.print(result[i--]);
System.out.println();
// -> 30414093201713378043612608166064768844377641568960512000000000000