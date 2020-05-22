IloCplex cplex = new IloCplex();
        int n = 5;
        IloNumVar[][] x = new IloNumVar[n][];
        for (int i = 0; i < n; i++) {
            x[i] = cplex.boolVarArray(n,
                    new String[]{
                            "x_" + (i + 1) + "1",
                            "x_" + (i + 1) + "2",
                            "x_" + (i + 1) + "3",
                            "x_" + (i + 1) + "4",
                            "x_" + (i + 1) + "5",
                    });
        }
        IloLinearNumExpr expr = cplex.linearNumExpr();
        for (int j = 0; j < n; j++) {
            expr.addTerm(1.0, x[0][j]);
        }
        cplex.addEq(expr,1.0);

        System.out.println(cplex.toString());