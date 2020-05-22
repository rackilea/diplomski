List<String> varNames = results.getResultVars();

 while(results.hasNext()) {
       QuerySolution sol = (QuerySolution) results.next();
       for (String var: varNames) {
              System.out.println("value of " + var + ": " + sol.get(var));
       }
 }