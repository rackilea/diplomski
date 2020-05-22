// INIT

String[][] in = {{"A1", "A2"}, {"B1", "B2"}};
// in is array of 2 references (pointers) at String[] value.
// Let's say in@adr1 = [@r1, @r2] (at address @adr1 in memory)
// @r1 = array of two references to Strings [@"A1", @"A2"], @r2 = [@"B1", @"B2"]
String[][] inCopy = in.clone();
// inCopy has copy of top level array (content of in@adr1) at address @adr2
// inCopy@adr2 = [@r1, @r2];  so this is in new memory,
// but the values are old @r1 and @r2, sharing the second level arrays with "in"

// modification CASE 1

String[] x = {"X1", "X2"};  // x@adr3 = [@"X1", @"X2"]
in[0] = x;
// in@adr1 = [x@adr3, @r2], so in = [[X1, X2], [B1, B2]]
// inCopy@adr2 = [@r1, @r2], so inCopy = [[A1, A2], [B1, B2]]

// modification CASE 2 (on deeper level, where clone/copyOf didn't create copy)

in[1][0] = "X";  // @r2[0] modified to contain @"X";
// in@adr1 = [x@adr3, @r2], @r2 = [@"X", @"B2"],  in = [[X1, X2], [X, B2]]
// inCopy@adr2 = [@r1, @r2] (same @r2!), so inCopy = [[A1, A2], [X, B2]]