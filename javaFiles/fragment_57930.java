// Read model from file with name args[0] into cplex optimizer object
 cplex.importModel(args[0]);

 // Get the objective and modify it.
 IloObjective obj = cplex.getObjective();
 IloLinearNumExpr objExpr = (IloLinearNumExpr) obj.getExpr();
 IloLinearNumExprIterator iter = objExpr.linearIterator();
 // Loop through the linear objective and modify, as necessary.
 while (iter.hasNext()) {
   IloNumVar var = iter.nextNumVar();
   System.out.println("Old coefficient for " + var + ": " + iter.getValue());
   // Modify as needed.
   if ( var.getName().equals("x1") ) {
      iter.setValue(42);
      System.out.println("New coefficient for " + var + ": " + iter.getValue());
   }
 }
 // Save the changes.
 obj.setExpr(objExpr);

 // Assumes that there is an LP Matrix.  The fact that we used
 // importModel() above guarantees that there will be at least
 // one.
 IloLPMatrix lp = (IloLPMatrix) cplex.LPMatrixIterator().next();
 for (int i = 0; i < lp.getNrows(); i++) {
    IloRange range = lp.getRange(i);
    System.out.println("Constraint " + range.getName());
    IloLinearNumExpr conExpr = (IloLinearNumExpr) range.getExpr();
    IloLinearNumExprIterator conIter = conExpr.linearIterator();
    // Loop through the linear constraints and modify, as necessary.
    while (conIter.hasNext()) {
       IloNumVar var = conIter.nextNumVar();
       System.out.println("Coefficient for " + var + ": " + conIter.getValue());
       // Modify as needed (as above).
       if ( var.getName().equals("x1") ) {
          conIter.setValue(42);
          System.out.println("New coefficient for " + var + ": " + conIter.getValue());
       }
  }
  // Save changes (as above).
  range.setExpr(conExpr);
}
cplex.exportModel("modified.lp");

// Solve the model and display the solution if one was found
if ( cplex.solve() ) {
   // do something here.
}