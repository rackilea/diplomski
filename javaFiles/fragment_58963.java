public static IloLinearNumExpr generateObjs(Integer n, IloCplex cplex) throws IloException{

   IloNumVar[][] x = new IloNumVar[n][n];
   IloLinearNumExpr expr = cplex.linearNumExpr();
   Random r = new Random();

   for(int i = 0; i < n; i++) {
      x[i] = cplex.numVarArray(n, 0.0, Double.MAX_VALUE);
      for(int j = 0; j < n; j++) {
         x[i][j].setName("x[" + i + "][" + j + "]");
         if(i != j) {
            expr.addTerm(50 + r.nextInt(951), x[i][j]);
         }
      }
   }

   return expr;
}