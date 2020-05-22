IloCplex cplex = new IloCplex();
IloNumVar[][][] x = new IloNumVar[n][][];
     for (int i = 0; i < n; i++){
        x[i] = new IloNumVar[m][];
        for (int j = 0; j < m; j++){
          x[i][j] = cplex.boolVarArray(M);
        }     
     }