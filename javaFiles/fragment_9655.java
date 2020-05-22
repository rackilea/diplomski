// ...
ArrayList<IntegerVariable> all = new ArrayList<IntegerVariable>();
int n = 5; // number of rows and columns
IntegerVariable[][] rows = new IntegerVariable[n][n];
for(int i = 0; i < n; i++) {
  for(int j = 0; j < n; j++) {
    rows[i][j] = makeIntVar("rows["+i+","+j+"]", 0, 1);
    all.add(rows[i][j]);
  }
}
// convert ArrayList all to an array
model.addConstraint(eq(sum(all.toArray(new IntegerVariable[1])),1));
// ...