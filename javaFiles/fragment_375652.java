IloNumExpr objective = cplex.numExpr();

for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        objective = cplex.sum(objective,cplex.prod(y[i], z[j][i]));
    }
}
cplex.addMinimize(objective);